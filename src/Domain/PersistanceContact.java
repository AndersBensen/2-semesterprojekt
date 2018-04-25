/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import Persistence.IReader;
import Persistence.IWriter;
/**
 *
 * @author Peter
 */
public class PersistanceContact {
    
    private static PersistanceContact instance = null;
    private IWriter writer;
    private IReader reader;
    private CaseRequest caseRequest;
    private int currentCaseID;
    private int currentCaseRequestID;
    private int currentEmployeeID;
    
    
    public static PersistanceContact getInstance()
    {
        if (instance == null)
            instance = new PersistanceContact();
        return instance;
    }
    
    public int getCurrentCaseID(){
        currentCaseID++;
        writeCurrentIDs();
    return currentCaseID;
    }
    
    
    public int getCurrentCaseRequestID(){
        currentCaseRequestID++;
        writeCurrentIDs();
    return currentCaseRequestID;
    }
     
    public int getCurrentEmployeeID(){
        currentEmployeeID++;
        writeCurrentIDs();
    return currentEmployeeID;
    }
      
    private void readCurrentIDs(){
        int[] ids = reader.getCurrentIDs();
        this.currentCaseID = ids[0];
        this.currentCaseRequestID = ids[1];
        this.currentEmployeeID = ids[2];
        System.out.println("was read: " + currentCaseID + " " + currentCaseRequestID + " " + currentEmployeeID);
        
    }
    
    public void writeCurrentIDs(){
        writer.writeIDs(currentCaseID, currentCaseRequestID, currentEmployeeID);
    }
    
    
    public void injectWriter(IWriter writer){
        this.writer = writer;
    }
    
     public void injectReader(IReader reader){
        this.reader = reader;
        readCurrentIDs();
    }
    
    public void saveCaseRequest(CaseRequest caseRequest){
        this.caseRequest = caseRequest;
        writer.writeCaseRequest(caseRequest);
        System.out.println("Case request have been saved!");
    }
    
    public String saveCase(Case c){ 
        writer.writeCase(c);
        return "your case has been saved with the ID: " + c.getID();
    }
    
    public Person getPerson(long CPR){
       String[] p = reader.getPerson(CPR);
       if(p[0].equals(null)){
           System.out.println("Person wasnt found");
           return null;
       }
       Person person = new Person(Long.parseLong(p[0]), p[1], p[2].charAt(0), p[3], p[4], Integer.parseInt(p[5]), p[6]);
       return person;
    }
    
    public Employee getEmployee(int id) {
        String[] e = reader.getEmployee(id);
        Employee employee = null; 
        if(e[0].equals(null)){
            System.out.println("Employee wasn't found");
            return null;
        }
        
        if (e[10].equals("1")) {
            employee = new Secretary(Long.parseLong(e[0]), e[1], e[2].charAt(0), e[3], e[4], Integer.parseInt(e[5]), e[6], Integer.parseInt(e[7]), e[8], e[9]);
        }
        else if (e[10].equals("2")) {
            employee = new SocialWorker(Long.parseLong(e[0]), e[1], e[2].charAt(0), e[3], e[4], Integer.parseInt(e[5]), e[6], Integer.parseInt(e[7]), e[8], e[9]);
        }
        else if (e[10].equals("3")) {
            employee = new Admin(Long.parseLong(e[0]), e[1], e[2].charAt(0), e[3], e[4], Integer.parseInt(e[5]), e[6], Integer.parseInt(e[7]), e[8], e[9]);
        }
        else {
            System.out.println("Wrong position number retrieved.");
        }
        
        return employee;
    }
    
    public void saveEmployee(IEmployee employee) {
        if (employee instanceof Secretary) {
            writer.writeEmployee(employee, 1);
        }
        else if (employee instanceof SocialWorker) {
            writer.writeEmployee(employee, 2);
        }
        else if (employee instanceof Admin) {
            writer.writeEmployee(employee, 3);
        }
        else {
            System.out.println("Illegal position number.");
        }
    }
    
    public void deleteEmployee(int id) {
        writer.deleteEmployee(id);
    }
            
    public void logAction(int employeeID, LogAction action, String desc) {
        Log log = new Log(employeeID, action, desc);
        writer.writeLog(log);
    }  
    
    public IReader getReader(){
        return this.reader;
    }
    
    public IWriter getWriter(){
        return this.writer;
    }
    
    public Case getCase(int ID){
        String[] c = reader.getCase(ID);
        if(c[0].equals(null)){
            System.out.println("Case wasn't found");
            return null;
        }
        Case currentCase = new Case(Integer.parseInt(c[0]), Integer.parseInt(c[1]));
        
        currentCase.setCitizenIsInformed(Boolean.parseBoolean(c[2]));
        currentCase.setCitizenRepresentation(c[3]);
        currentCase.setNextAppointment(c[4]);
        currentCase.setGuardianship(c[5]);
        currentCase.setPersonalHelper(c[6]);
        currentCase.setPersonalHelperPowerOfAttorney(Boolean.parseBoolean(c[7]));
        currentCase.setCitizenRights(c[8]);
        currentCase.setCitizenInformedElectronic(Boolean.parseBoolean(c[9]));
        currentCase.setConsent(Boolean.parseBoolean(c[10]));
        currentCase.setConsentType(c[11]);
        currentCase.setCollectCitizenInfo(c[12]);
        currentCase.setSpecialCircumstances(c[3]);
        currentCase.setDifferentCommune(c[14]);
        
        
        return currentCase;
        
    }
    
    public CaseRequest getCaseRequest(int caseRequestID){
        String[]cr = reader.getCaseRequest(caseRequestID);
        
        if(cr[0].equals(null)){
            System.out.println("CaseRequest wasn't found");
            return null;
        }
        
        long l = Long.parseLong(cr[8]);     //CPR
        int i1 = Integer.parseInt(cr[0]);   //EmployeeID
        int i2 = Integer.parseInt(cr[1]);   //CaseReqID
        
        CaseRequest currentCaseRequest = new CaseRequest(i1,i2 , l);
        
        currentCaseRequest.setDescription(cr[2]);
        currentCaseRequest.setMessageClear(Boolean.parseBoolean(cr[3]));
        currentCaseRequest.setCarePackageRequested(Boolean.parseBoolean(cr[4]));
        currentCaseRequest.setRehousingPackageRequested(Boolean.parseBoolean(cr[5]));
        currentCaseRequest.setRequestPerson(cr[6]);
        currentCaseRequest.setCitizenInformed(Boolean.parseBoolean(cr[7]));
        currentCaseRequest.connectCitizen(l, cr[9], cr[10].charAt(0), cr[11], cr[12]);  //cpr, name, gender, birthday, address
        currentCaseRequest.setCitizenPhoneNr(Integer.parseInt(cr[13]));
        currentCaseRequest.setCitizenMail(cr[14]);
        
        
        return currentCaseRequest;
        
    }
   
    
    
}
