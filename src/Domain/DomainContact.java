package Domain;

public class DomainContact implements IDomainContact {

    private Employee currentUser;
    private static DomainContact instance = null;

    public static DomainContact getInstance() {
        if (instance == null) {
            instance = new DomainContact();
        }
        return instance;
    }

    private DomainContact() {
        this.currentUser = new SocialWorker(1000950000, "Morten", 'M', "10-01-0000", "Hejsavej", 88888888, "hej@nal.mail", 6, "Loc", "1234567");
        PersistanceContact PS = PersistanceContact.getInstance();
        PS.logAction(currentUser.getId(), LogAction.LOG_IN, "User logged in");
    }

    @Override
    public void createCaseRequest(long citizenCPR, String desc, boolean isMessageClear, boolean isCarePackage, boolean isRehousingPackage, String requestPerson, boolean isCitizenInformed, String citizenName, char citizenGender, String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr, String citizenMail) {
        if (currentUser instanceof CaseEmployee) {
            CaseEmployee caseUser = (CaseEmployee) currentUser;
            caseUser.createCaseRequest(0, currentUser.getId(), citizenCPR, desc, isMessageClear, isCarePackage, isRehousingPackage, requestPerson, isCitizenInformed, citizenName, citizenGender, citizenBirthdate, citizenAddress, citizenPhoneNr, citizenMail);
        }
        else
            System.out.println("User not allowed to perform command: createCaseRequest");
    }

    @Override
    public void createCase(int caseRequestID, String nextAppointment, String guardianship, String personalHelper, String personalHelperPowerOfAttorney, String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType, String[] collectCitizenInfo, String specialCircumstances, String differentCommune) {
        if (currentUser instanceof SocialWorker) {
            SocialWorker socialWorker = (SocialWorker) currentUser;
            socialWorker.saveCase(PersistanceContact.getInstance().getCurrentCaseID(), caseRequestID, nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent, consentType, collectCitizenInfo, specialCircumstances, differentCommune);
        }
        else
            System.out.println("User not allowed to perform command: createCase");
    }
    
    @Override
    public void saveEditedCase(int caseID, int caseRequestID, String nextAppointment, String guardianship, String personalHelper, String personalHelperPowerOfAttorney, String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType, String[] collectCitizenInfo, String specialCircumstances, String differentCommune) {
        if (currentUser instanceof SocialWorker) {
            SocialWorker socialWorker = (SocialWorker) currentUser;
            socialWorker.saveCase(caseID, caseRequestID, nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent, consentType, collectCitizenInfo, specialCircumstances, differentCommune);
        }
        else
            System.out.println("User not allowed to perform command: saveEditedCase");
    }

    @Override
    public void addEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPerson getPerson(long CPR) {
        PersistanceContact PS = PersistanceContact.getInstance();
        PS.logAction(currentUser.getId(), LogAction.GET_EMPLOYEE, "User requested for a person with CPR: " + CPR);
        return PS.getPerson(CPR);
    }
    
    public Employee getCurrentUser() {
        return currentUser;
    }
}
