package Domain;

import java.util.Date;

public class SocialWorker extends CaseEmployee {

    // *******************************
    // ********* Constructor *********
    // *******************************
    public SocialWorker(String cpr, String name, char gender, String birthDate, String address, Integer phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
    }

    /**
     * This method sends a case to the database.
     * It takes the information that a case needs and create an instance
     * of it and sends it to the database. It also logs activity with a
     * description of the activity.
     *
     * @param ID
     * @param employeeID
     * @param caseRequestID
     * @param nextAppointment
     * @param guardianship
     * @param personalHelperPowerOfAttorney
     * @param personalHelper
     * @param citizenRights
     * @param citizenInformedElectronic
     * @param consent
     * @param specialCircumstances
     * @param collectCitizenInfo
     * @param consentType
     * @param differentCommune
     * @param state
     * @return (int) The id of the newly created Case. If the value is -1, a 
     * case was not created correctly and therefore wasn't saved in
     * the database
     */
    public int saveCase(int ID, int employeeID, int caseRequestID, String nextAppointment,
            String guardianship, String personalHelper, String personalHelperPowerOfAttorney,
            String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType,
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune, String state) {
        
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        CaseRequest caseRequest = pc.getCaseRequest(caseRequestID);
        Case c = new Case(ID, employeeID, caseRequest);
        c.setNextAppointment(nextAppointment);
        c.setGuardianship(guardianship);
        c.setPersonalHelper(personalHelper);
        c.setPersonalHelperPowerOfAttorney(personalHelperPowerOfAttorney);
        c.setCitizenRights(citizenRights);
        c.setCitizenInformedElectronic(citizenInformedElectronic);
        c.setConsent(consent);
        c.setConsentType(consentType);
        c.setCollectCitizenInfo(collectCitizenInfo);
        c.setSpecialCircumstances(specialCircumstances);
        c.setDifferentCommune(differentCommune);
        c.setState(state);
        int returnInt = pc.saveCase(c);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.SAVE_CASE, "Created a new case");
        
        return returnInt;
    }
    
    
    /**
     * This method sends an edited case to the database.
     * It takes the information that a case needs and create an instance
     * of it and sends it to the database. It also logs activity with a
     * description of the activity.
     *
     * @param ID int
     * @param employeeID int
     * @param caseRequestID int
     * @param nextAppointment String
     * @param guardianship String
     * @param personalHelper String
     * @param personalHelperPowerOfAttorney String
     * @param citizenRights String
     * @param citizenInformedElectronic boolean
     * @param consent boolean
     * @param consentType String
     * @param collectCitizenInfo String[]
     * @param specialCircumstances String
     * @param differentCommune String
     * @param state String
     * @param dateCreated Date
     * @return (int) The id of the edited Case. If the value is -1, a 
     * case was stored correctly and therefore wasn't saved in the database
     */
    public int saveEditedCase(int ID, int employeeID, int caseRequestID, String nextAppointment,
            String guardianship, String personalHelper, String personalHelperPowerOfAttorney,
            String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType,
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune, String state, Date dateCreated) {

        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        CaseRequest caseRequest = pc.getCaseRequest(caseRequestID);
        Case c = new Case(ID, employeeID, caseRequest, dateCreated, new Date());
        c.setNextAppointment(nextAppointment);
        c.setGuardianship(guardianship);
        c.setPersonalHelper(personalHelper);
        c.setPersonalHelperPowerOfAttorney(personalHelperPowerOfAttorney);
        c.setCitizenRights(citizenRights);
        c.setCitizenInformedElectronic(citizenInformedElectronic);
        c.setConsent(consent);
        c.setConsentType(consentType);
        c.setCollectCitizenInfo(collectCitizenInfo);
        c.setSpecialCircumstances(specialCircumstances);
        c.setDifferentCommune(differentCommune);
        c.setState(state);
        pc.saveCase(c);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.EDIT_CASE, "Edited a case with the following id: " + ID);
        return c.getID();
    }
    

    /**
     * This method ask the database for a case with a specific id and logs the 
     * activity with a description.
     *
     * @param caseID int
     * @return (Case) The case if any with the specific id
     */
    public Case editCase(int caseID) {
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        pc.logAction(dc.getCurrentUser().getId(), LogAction.GET_CASE, "Viewed a case with rights to edit");
        return pc.getCase(caseID);
    }
}
