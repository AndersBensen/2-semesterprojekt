/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author ander
 */
public class SocialWorker extends CaseEmployee{
    
    public SocialWorker(long cpr, String name, char gender, String birthDate, String address, int phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
    }
    
    /**
     * This method creates a case and logs the activity with a description
     * with what happened. 
     * @param caseRequestID
     * @return int, id of the case creater 
     */
    public int createCase(int caseRequestID) {
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance(); 
        // TO DO CREATE CASE 
        Case c = new Case(pc.getCurrentCaseID(), caseRequestID);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.SAVE_CASE, "Created a new case");
        return c.getID();
    }

    /**
     * This method edits a case and logs the activity with a description. 
     * @param caseID
     * @return Case, the case that was edited
     */
    public Case editCase(int caseID) {
        // TO DO EDIT CASE
       DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        pc.logAction(dc.getCurrentUser().getId(), LogAction.GET_CASE, "Viewed a case with rights to edit");
         return pc.getCase(caseID);
    }
    
    /**
     * This method saves a case after a case has been edited. It also logs
     * the activity with a description of what happened. 
     * @param c 
     */
    public void saveCase(Case c){
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        pc.saveCase(c);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.SAVE_CASE, "Saved an edited case");
    }
    
}
