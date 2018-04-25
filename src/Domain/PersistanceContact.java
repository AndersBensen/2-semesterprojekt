/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import Domain.Case;
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
    
    public static PersistanceContact getInstance()
    {
        if (instance == null)
            instance = new PersistanceContact();
        
        return instance;
    }
    
    public void injectWriter(IWriter writer){
        this.writer = writer;
    }
    
     public void injectReader(IReader reader){
        this.reader = reader;
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
       Person person = new Person(Long.parseLong(p[0]), p[1], p[2].charAt(0), p[3], p[4], Integer.parseInt(p[5]), p[6]);
       return person;
    }
    
    public IReader getReader(){
        return this.reader;
    }
    
    public IWriter getWriter(){
        return this.writer;
    }
    
    public Case getCase(int ID){
        String[] c = reader.getCase(ID);
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
