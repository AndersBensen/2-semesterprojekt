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
        this.currentUser = new Secretary(1000950000, "Morten", 'M', "10-01-0000", "Hejsavej", 88888888, "hej@nal.mail", 6, "Loc", "1234567");
    }

    @Override
    public boolean saveCaseRequest(long citizenCPR, String desc, boolean isMessageClear, boolean isCarePackage, boolean isRehousingPackage, String requestPerson, boolean isCitizenInformed, String citizenName, char citizenGender, String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr, String citizenMail) {
        if (currentUser instanceof CaseEmployee) {
            CaseEmployee caseUser = (CaseEmployee) currentUser;
            caseUser.createCaseRequest(0, currentUser.getId(), citizenCPR, desc, isMessageClear, isCarePackage, isRehousingPackage, requestPerson, isCitizenInformed, citizenName, citizenGender, citizenBirthdate, citizenAddress, citizenPhoneNr, citizenMail);
        }
        return true;
    }

    @Override
    public String saveCase(int ID, CaseRequest caseRequest, boolean citizenIsInformed, String citizenRepresentation, String nextAppointment, String guardianship, String personalHelper, String personalHelperPowerOfAttorney, String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType, String[] collectCitizenInfo, String specialCircumstances, String differentCommune) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}