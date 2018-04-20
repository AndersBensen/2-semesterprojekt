package Domain;


public interface IDomainContact {
    public boolean saveCaseRequest(int citizenID, String desc, boolean isMessageClear, 
            boolean isCarePackage, boolean isRehousingPackage, String contact, boolean isCitizenInformed);
    
    public String saveCase(int ID, CaseRequest caseRequest, boolean citizenIsInformed, 
            String citizenRepresentation, String nextAppointment, String guardianship, 
            String personalHelper, String personalHelperPowerOfAttorney, String citizenRights, 
            boolean citizenInformedElectronic, boolean consent, String consentType, 
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune);
    
    public void addEmployee();
    
    public void deleteEmployee();
}
