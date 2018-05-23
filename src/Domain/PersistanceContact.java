package Domain;

import Acquaintance.IReader;
import Acquaintance.IWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersistanceContact {

    // *******************************
    // *********  Singleton  *********
    // *******************************
    private static PersistanceContact instance = null;
    public static PersistanceContact getInstance() {
        if (instance == null) {
            instance = new PersistanceContact();
        }
        return instance;
    }

    private PersistanceContact() {}
    
    // *******************************
    // ********   Attributes  ********
    // *******************************
    
    // Recerences to the writer and reader of the database
    private IWriter writer;
    private IReader reader;
    
    // Information about the current system
    private int currentCaseID;
    private int currentCaseRequestID;
    private int currentEmployeeID;


    /**
     * Injects a writer to the PersistanceContact.
     *
     * @param writer
     */
    public void injectWriter(IWriter writer) {
        this.writer = writer;
    }

    /**
     * Injects a reader to the PersistanceContact.
     *
     * @param reader
     */
    public void injectReader(IReader reader) {
        this.reader = reader;
        readCurrentIDs();
    }

    /**
     * This method sends the case request to the writer to be stored in the 
     * database.
     *
     * @param caseRequest CaseRequest
     * @return (int) The id of the newly created CaseRequest. If the value is -1,
     * a case request was not created correctly and therefore wasn't saved in
     * the database
     */
    public int saveCaseRequest(CaseRequest caseRequest) {
        System.out.println("PersistenceContact: saveCaseRequest");
        return writer.writeCaseRequest(caseRequest);
    }

    /**
     * This method sends the case to the writer to be stored in the database.
     *
     * @param c Case
     * @return (int) The id of the newly created Case. If the value is -1, a 
     * case was not created correctly and therefore wasn't saved in the database
     */
    public int saveCase(Case c) {
        System.out.println("PersistenceContact: saveCase");
        return writer.writeCase(c);
    }

    /**
     * This method sends the employee to the writer to be stored in the database.
     *
     * @param employee Employee
     * @return (int) The id of the newly created Employee. If the value is -1, an
     * employee was not created correctly and therefore wasn't saved in the
     * database
     */
    public int saveEmployee(Employee employee) {
        System.out.println("PersistenceContact: saveEmployee");
        
        int returnInt = -1;
        if (employee instanceof Secretary) {
            returnInt = writer.writeEmployee(employee, 1);
        } else if (employee instanceof SocialWorker) {
            returnInt = writer.writeEmployee(employee, 2);
        } else if (employee instanceof Admin) {
            returnInt = writer.writeEmployee(employee, 3);
        } else {
            System.out.println("PersistenceContact: Illegal position number in saveEmployee()");
        }

        return returnInt;
    }

    /**
     * This method sends the id of an employee to the writer to be deleted from 
     * the database.
     *
     * @param id int
     * @return (int) The id of the deleted Employee. If the value is -1, an 
     * employee was not deleted correctly and therefore wasn't removed from the 
     * database
     */
    public int deleteEmployee(int id) {
        System.out.println("PersistenceContact: deleteEmployee");
        return writer.deleteEmployee(id);
    }

    /**
     * This method takes information which should be logged and sends it to the 
     * writer to be stored in the database.
     *
     * @param employeeID int
     * @param action LogAction
     * @param desc String
     */
    public void logAction(int employeeID, LogAction action, String desc) {
        System.out.println("PersistenceContact: logAction");
        
        Log log = new Log(employeeID, action, desc);
        writer.writeLog(log);
    }

    /**
     * This method sends information to the database to check if the username
     * and password matches any users in the system.
     * 
     * @param username
     * @param password
     * @return (Employee) Returns the employee if any with the specific username
     *  and password
     */
    public Employee login(String username, String password) {
        System.out.println("PersistenceContact: login");
        
        String[] e = reader.login(username, password);
        if (e[0] == null) {
            System.out.println("User doesn't exist");
            return null;
        }
        Employee employee = createEmployee(e);

        return employee;
    }

    /**
     * This method retrieves a case request with the specific id from the
     * database through the reader.
     *
     * @param ID int
     * @return (CaseRequest) Returns the case request if any with the specific 
     * id
     */
    public CaseRequest getCaseRequest(int ID) {
        String[] cr = reader.getCaseRequest(ID);
        if (cr[0] == null) {
            System.out.println("CaseRequest wasn't found");
            return null;
        }
        
        String CPR = cr[8];                             //CPR
        int employeeID = Integer.parseInt(cr[0]);       //EmployeeID
        int caseRequestID = Integer.parseInt(cr[1]);    //CaseReqID

        Integer citizenPhoneNr = cr[13].trim().equals("-1") ? null : Integer.parseInt(cr[13]);
        Person citizen = new Person(CPR, cr[9], cr[10].charAt(0), cr[11], cr[12], citizenPhoneNr, cr[14]);
        Date dateCreated = new Date(Long.parseLong(cr[15]));
        Date dateModified = new Date(Long.parseLong(cr[16]));

        CaseRequest currentCaseRequest = new CaseRequest(employeeID, caseRequestID, citizen, dateCreated, dateModified);

        currentCaseRequest.setDescription(cr[2]);
        currentCaseRequest.setMessageClear(getBooleanFromInput(cr[3]));
        currentCaseRequest.setCarePackageRequested(cr[4].split("#"));
        currentCaseRequest.setRehousingPackageRequested(cr[5]);
        currentCaseRequest.setRequestPerson(cr[6]);
        currentCaseRequest.setCitizenInformed(getBooleanFromInput(cr[7]));

        return currentCaseRequest;
    }

    /**
     * This method retrieves a case with the specific id from the database 
     * through the reader.
     *
     * @param ID int
     * @return (Case) Returns the case if any with the specific id
     */
    public Case getCase(int ID) {
        String[] c = reader.getCase(ID);
        if (c[0] == null) {
            System.out.println("Case wasn't found");
            return null;
        }

        int caseRequestID = Integer.parseInt(c[2]);
        int caseID = Integer.parseInt(c[0]);
        CaseRequest caseRequest = getCaseRequest(caseRequestID);
        logAction(DomainContact.getInstance().getCurrentUser().getId(), LogAction.GET_CASE_REQUEST, "Retrieved CaseRequest (ID " + caseRequest + ") for Case (ID " + caseID + ")");
        Date dateCreated = new Date(Long.parseLong(c[15]));
        Date dateModified = new Date(Long.parseLong(c[16]));
        Case currentCase = new Case(caseID, Integer.parseInt(c[1]), caseRequest, dateCreated, dateModified);
        currentCase.setNextAppointment(c[3]);
        currentCase.setGuardianship(c[4]);
        currentCase.setPersonalHelper(c[5]);
        currentCase.setPersonalHelperPowerOfAttorney(c[6]);
        currentCase.setCitizenRights(c[7]);
        currentCase.setCitizenInformedElectronic(getBooleanFromInput(c[8]));
        currentCase.setConsent(getBooleanFromInput(c[9]));
        currentCase.setConsentType(c[10]);
        currentCase.setCollectCitizenInfo(c[11].split("#"));
        currentCase.setSpecialCircumstances(c[12]);
        currentCase.setDifferentCommune(c[13]);
        currentCase.setState(c[14]);
        return currentCase;
    }
    
    /**
     * This method is used to retrieve all cases and case requests as
     * CaseObjects that affect a citizen with the specific CPR.
     * 
     * @param citizenCPR String
     * @return (List CaseObject) Returns all the CaseObjects that responds to
     * the citizen's CPR
     */
    public List<CaseObject> getCaseObject(String citizenCPR) {
        List<CaseObject> caseObjects = new ArrayList<>();
        
        for (String[] simpleCase : reader.getSimpleCases(citizenCPR)) {
            int id = Integer.parseInt(simpleCase[0]);
            int employeeID = Integer.parseInt(simpleCase[1]);
            String description = simpleCase[2];
            Date dateCreated = new Date(Long.parseLong(simpleCase[3]));
            
            CaseObject caseObject = new CaseObject(id, employeeID, "Case", description, dateCreated);
            caseObjects.add(caseObject);
        }
        
        for (String[] simpleCase : reader.getSimpleCaseRequests(citizenCPR)) {
            int id = Integer.parseInt(simpleCase[0]);
            int employeeID = Integer.parseInt(simpleCase[1]);
            String description = simpleCase[2];
            Date dateCreated = new Date(Long.parseLong(simpleCase[3]));
            
            CaseObject caseObject = new CaseObject(id, employeeID, "CaseRequest", description, dateCreated);
            caseObjects.add(caseObject);
        }
        
        return caseObjects;
    }

    /**
     * This method retrieves a person with the specific CPR from the database 
     * through the reader.
     *
     * @param CPR String
     * @return (Person) Returns the Person if any with the specific id
     */
    public Person getPerson(String CPR) {
        String[] p = reader.getPerson(CPR);
        if (p[0] == null) {
            System.out.println("Person wasnt found");
            return null;
        }

        //Integer personPhoneNr = p[5].equals("") ? null : Integer.parseInt(p[5]);

        Person person = new Person(p[0], p[1], p[2].charAt(0), p[3], p[4], null, "");

        return person;
    }

    /**
     * This method retrieves an employee with the specific id from the database 
     * through the reader.
     *
     * @param ID int
     * @return (Employee) Returns the Employee if any with the specific id
     */
    public Employee getEmployee(int ID) {
        String[] e = reader.getEmployee(ID);
        if (e[0] == null) {
            System.out.println("Employee wasn't found");
            return null;
        }
        Employee employee = createEmployee(e);

        return employee;
    }

    /**
     * This method retrieves the ID for a new case request.
     *
     * @return (int) Returns the id
     */
    public int getNewCaseRequestID() {
        currentCaseRequestID++;
        writeCurrentIDs();
        return currentCaseRequestID;
    }

    /**
     * This method retrieves the ID for a new case.
     *
     * @return (int) Returns the id
     */
    public int getNewCaseID() {
        currentCaseID++;
        writeCurrentIDs();
        return currentCaseID;
    }

    /**
     * This method retrieves the ID for a new employee.
     *
     * @return (int) Returns the id
     */
    public int getNewEmployeeID() {
        currentEmployeeID++;
        writeCurrentIDs();
        return currentEmployeeID;
    }

    /**
     * This method initialize the id attributes with information from the 
     * database. This method is called when a reader is injected into the 
     * PersistanceContant
     */
    private void readCurrentIDs() {
        int[] ids = reader.getCurrentIDs();
        this.currentCaseID = ids[0];
        this.currentCaseRequestID = ids[1];
        this.currentEmployeeID = ids[2];
    }

    /**
     * Writes the current IDs to the database. This method is called whenever
     * there is a change in those fields.
     * @deprecated This method is not to be used with a relationel database. It
     * should only be used with the database using textfiles
     */
    private void writeCurrentIDs() {
        //writer.writeIDs(currentCaseID, currentCaseRequestID, currentEmployeeID);
    }

    /**
     * This method creates an employee based on the information given.
     * 
     * @param e String[]
     * @return (Employee) Returns the employee created
     */
    private Employee createEmployee(String[] e) {
        Employee employee = null;
        Integer employeePhoneNr = e[5].trim().equals("-1") ? null : Integer.parseInt(e[5]);

        switch (e[10]) {
            case "1":
                employee = new Secretary(e[0].trim(), e[1], e[2].charAt(0), e[3], e[4], employeePhoneNr, e[6], Integer.parseInt(e[7]), e[8], e[9]);
                break;
            case "2":
                employee = new SocialWorker(e[0].trim(), e[1], e[2].charAt(0), e[3], e[4], employeePhoneNr, e[6], Integer.parseInt(e[7]), e[8], e[9]);
                break;
            case "3":
                employee = new Admin(e[0].trim(), e[1], e[2].charAt(0), e[3], e[4], employeePhoneNr, e[6], Integer.parseInt(e[7]), e[8], e[9]);
                break;
            default:
                System.out.println("Wrong position number retrieved.");
                break;
        }
        return employee;
    }
    
    /**
     * Transform a string to the corresponding boolean.
     * 
     * @param input String
     * @return (boolean) Returns the boolean which correspond to the String
     */
    private boolean getBooleanFromInput(String input) {
        if (input.equalsIgnoreCase("T") || input.equalsIgnoreCase("true")) {
            return true;
        } else if (input.equalsIgnoreCase("F") || input.equalsIgnoreCase("false")) {
            return false;
        } else {
            System.out.println("Method getBooleanFromInput: CANNOT CONVERT STRING TO BOOLEAN");
            return false;
        }
    }
}
