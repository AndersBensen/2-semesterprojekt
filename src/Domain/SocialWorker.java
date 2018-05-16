package Domain;

import java.util.Date;

public class SocialWorker extends CaseEmployee {

    public SocialWorker(String cpr, String name, char gender, String birthDate, String address, Integer phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
    }

    /**
     * This method creates a case and logs the activity with a description with
     * what happened.
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
     * @return int, id of the case creater
     */
    public int saveCase(int ID, int employeeID, int caseRequestID, String nextAppointment,
            String guardianship, String personalHelper, String personalHelperPowerOfAttorney,
            String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType,
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune) {

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
        pc.saveCase(c);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.SAVE_CASE, "Created a new case");
        return c.getID();
    }
    
    
    /**
     * This method creates a case and logs the activity with a description with
     * what happened.
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
     * @param dateCreated
     * @return int, id of the case creater
     */
    public int saveEditedCase(int ID, int employeeID, int caseRequestID, String nextAppointment,
            String guardianship, String personalHelper, String personalHelperPowerOfAttorney,
            String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType,
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune, Date dateCreated) {

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
        pc.saveCase(c);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.EDIT_CASE, "Edited a case with the following id: " + ID);
        return c.getID();
    }
    

    /**
     * This method edits a case and logs the activity with a description.
     *
     * @param caseID
     * @return Case, the case that was edited
     */
    public Case editCase(int caseID) {
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        pc.logAction(dc.getCurrentUser().getId(), LogAction.GET_CASE, "Viewed a case with rights to edit");
        return pc.getCase(caseID);
    }
}
