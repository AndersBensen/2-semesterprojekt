package Domain;


public class DomainContact implements IDomainContact {

    private Employee currentUser;
    
    @Override
    public boolean saveCaseRequest(int citizenID, String desc, boolean isMessageClear, boolean isCarePackage, boolean isRehousingPackage, String contact, boolean isCitizenInformed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
