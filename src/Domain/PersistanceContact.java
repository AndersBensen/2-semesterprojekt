/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Acquaintance.IReader;
import Acquaintance.IWriter;

/**
 *
 * @author Peter
 */
public class PersistanceContact
{

    private static PersistanceContact instance = null;
    private IWriter writer;
    private IReader reader;
    private int currentCaseID;
    private int currentCaseRequestID;
    private int currentEmployeeID;

    public static PersistanceContact getInstance()
    {
        if (instance == null)
        {
            instance = new PersistanceContact();
        }
        return instance;
    }

    private PersistanceContact() {}

    /**
     * Injects a writer to the PersistanceContact.
     *
     * @param writer
     */
    public void injectWriter(IWriter writer)
    {
        this.writer = writer;
    }

    /**
     * Injects a reader to the PersistanceContact.
     *
     * @param reader
     */
    public void injectReader(IReader reader)
    {
        this.reader = reader;
        readCurrentIDs();
    }

    /**
     * Saves the case request.
     *
     * @param caseRequest
     * @return 
     */
    public String saveCaseRequest(CaseRequest caseRequest)
    {
        writer.writeCaseRequest(caseRequest);
        return "Case request has been saved with the ID: " + caseRequest.getID();
    }

    /**
     * Saves the case
     *
     * @param c
     * @return String for the user.
     */
    public String saveCase(Case c)
    {
        writer.writeCase(c);
        return "Case has been saved with the ID: " + c.getID();
    }
    
    /**
     * Save the employee to the database
     * @param employee 
     * @return  
     */
    public String saveEmployee(Employee employee)
    {
        if (employee instanceof Secretary)
        {
            writer.writeEmployee(employee, 1);
        } else if (employee instanceof SocialWorker)
        {
            writer.writeEmployee(employee, 2);
        } else if (employee instanceof Admin)
        {
            writer.writeEmployee(employee, 3);
        } else
        {
            System.out.println("Illegal position number.");
        }
        
        return "Employee with the ID: " + employee.getId() + " was saved";
    }

    /**
     * Deletes the employee from the database
     * @param id ID of employee
     * @return 
     */
    public String deleteEmployee(int id)
    {
        writer.deleteEmployee(id);
        return "Employee with the ID: " + id + " was deleted";
    }
    
    public Employee login(String username, String password) {
        String[] e = reader.login(username, password);
        if (e[0] == null)
        {
            System.out.println("User doesn't exist");
            return null;
        }
        Employee employee = createEmployee(e);

        return employee;
    }
    
    /**
     * Saves a log of the action performed
     * @param employeeID
     * @param action
     * @param desc
     */
    public void logAction(int employeeID, LogAction action, String desc)
    {
        Log log = new Log(employeeID, action, desc);
        writer.writeLog(log);
    }

    /**
     * Gets the case request based on the case request ID
     *
     * @param ID the id of the CaseRequest
     * @return CaseRequest
     */
    public CaseRequest getCaseRequest(int ID)
    {
        String[] cr = reader.getCaseRequest(ID);
        if (cr[0] == null)
        {
            System.out.println("CaseRequest wasn't found");
            return null;
        }

        long CPR = Long.parseLong(cr[8]);               //CPR
        int employeeID = Integer.parseInt(cr[0]);       //EmployeeID
        int caseRequestID = Integer.parseInt(cr[1]);    //CaseReqID
        
        Integer citizenPhoneNr = cr[13].equals("")? null : Integer.parseInt(cr[13]);
        
        CaseRequest currentCaseRequest = new CaseRequest(employeeID, caseRequestID, CPR);

        currentCaseRequest.setDescription(cr[2]);
        currentCaseRequest.setMessageClear(Boolean.parseBoolean(cr[3]));
        currentCaseRequest.setCarePackageRequested(Boolean.parseBoolean(cr[4]));
        currentCaseRequest.setRehousingPackageRequested(Boolean.parseBoolean(cr[5]));
        currentCaseRequest.setRequestPerson(cr[6]);
        currentCaseRequest.setCitizenInformed(Boolean.parseBoolean(cr[7]));
        currentCaseRequest.connectCitizen(CPR, cr[9], cr[10].charAt(0), cr[11], cr[12]);  //cpr, name, gender, birthday, address
        currentCaseRequest.setCitizenPhoneNr(citizenPhoneNr);
        currentCaseRequest.setCitizenMail(cr[14]);

        return currentCaseRequest;
    }

    /**
     * Gets the case based on the case ID
     *
     * @param ID The id of the Case
     * @return Case
     */
    public Case getCase(int ID)
    {
        String[] c = reader.getCase(ID);
        if (c[0] == null)
        {
            System.out.println("Case wasn't found");
            return null;
        }
        
        int caseRequestID = Integer.parseInt(c[2]);
        CaseRequest caseRequest = getCaseRequest(caseRequestID);
        int caseID = Integer.parseInt(c[0]);
        logAction(DomainContact.getInstance().getCurrentUser().getId(), LogAction.GET_CASE_REQUEST, "Retrieved CaseRequest (ID " + caseRequest + ") for Case (ID " + caseID + ")");
        Case currentCase = new Case(caseID, Integer.parseInt(c[1]), caseRequest);
        currentCase.setNextAppointment(c[3]);
        currentCase.setGuardianship(c[4]);
        currentCase.setPersonalHelper(c[5]);
        currentCase.setPersonalHelperPowerOfAttorney(c[6]);
        currentCase.setCitizenRights(c[7]);
        currentCase.setCitizenInformedElectronic(Boolean.parseBoolean(c[8]));
        currentCase.setConsent(Boolean.parseBoolean(c[9]));
        currentCase.setConsentType(c[10]);
        currentCase.setCollectCitizenInfo(c[11].split("#"));
        currentCase.setSpecialCircumstances(c[12]);
        currentCase.setDifferentCommune(c[13]);
        System.out.println("caseRequest: " + caseRequest);
        return currentCase;
    }

    /**
     * Gets the person based on a CPR number
     * @param CPR
     * @return Person
     */
    public Person getPerson(long CPR)
    {
        String[] p = reader.getPerson(CPR);
        if (p[0] == null)
        {
            System.out.println("Person wasnt found");
            return null;
        }
        
        Integer personPhoneNr = p[5].equals("")? null : Integer.parseInt(p[5]);
        
        Person person = new Person(Long.parseLong(p[0]), p[1], p[2].charAt(0), p[3], p[4], personPhoneNr, p[6]);

        return person;
    }

    /**
     * Gets an employee based on the ID
     * @param ID
     * @return Employee
     */
    public Employee getEmployee(int ID)
    {
        String[] e = reader.getEmployee(ID);
        if (e[0] == null)
        {
            System.out.println("Employee wasn't found");
            return null;
        }
        Employee employee = createEmployee(e);
     
        return employee;
    }

    /**
     * Gets a case request ID for a new case request.
     *
     * @return int currentCaseRequestID
     */
    public int getNewCaseRequestID()
    {
        currentCaseRequestID++;
        writeCurrentIDs();
        return currentCaseRequestID;
    }

    /**
     * Gets a case ID for a new case.
     *
     * @return int currentCaseID
     */
    public int getNewCaseID()
    {
        currentCaseID++;
        writeCurrentIDs();
        return currentCaseID;
    }

    /**
     * Gets a employee ID for a new employee.
     *
     * @return int currentEmployeeID
     */
    public int getNewEmployeeID()
    {
        currentEmployeeID++;
        writeCurrentIDs();
        return currentEmployeeID;
    }

    /**
     * Method is used to set the fields in PersistenceContact. This method is
     * called when a reader is injected to PersistanceContant.
     */
    private void readCurrentIDs()
    {
        int[] ids = reader.getCurrentIDs();
        this.currentCaseID = ids[0];
        this.currentCaseRequestID = ids[1];
        this.currentEmployeeID = ids[2];
    }

    /**
     * Writes the current IDs to the database. This method is called whenever
     * there is a change in those fields.
     */
    private void writeCurrentIDs()
    {
        //writer.writeIDs(currentCaseID, currentCaseRequestID, currentEmployeeID);
    }
    
    private Employee createEmployee(String[] e) {
        Employee employee = null;
        Integer employeePhoneNr = e[5].equals("")? null : Integer.parseInt(e[5]);
        
        switch (e[10])
        {
            case "1":
                employee = new Secretary(Long.parseLong(e[0]), e[1], e[2].charAt(0), e[3], e[4], employeePhoneNr, e[6], Integer.parseInt(e[7]), e[8], e[9]);
                break;
            case "2":
                employee = new SocialWorker(Long.parseLong(e[0]), e[1], e[2].charAt(0), e[3], e[4], employeePhoneNr, e[6], Integer.parseInt(e[7]), e[8], e[9]);
                break;
            case "3":
                employee = new Admin(Long.parseLong(e[0]), e[1], e[2].charAt(0), e[3], e[4], employeePhoneNr, e[6], Integer.parseInt(e[7]), e[8], e[9]);
                break;
            default:
                System.out.println("Wrong position number retrieved.");
                break;
        }
        return employee;
    }

}
