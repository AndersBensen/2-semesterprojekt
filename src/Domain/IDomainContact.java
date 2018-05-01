package Domain;

public interface IDomainContact {

    public void createCaseRequest(long citizenCPR, String desc, boolean isMessageClear,
            boolean isCarePackage, boolean isRehousingPackage, String requestPerson,
            boolean isCitizenInformed, String citizenName, char citizenGender,
            String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr, String citizenMail);

    public void createCase(int caseRequestID, String nextAppointment, String guardianship,
            String personalHelper, String personalHelperPowerOfAttorney, String citizenRights,
            boolean citizenInformedElectronic, boolean consent, String consentType,
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune);

    public void saveEditedCase(int caseID, int caseRequestID, String nextAppointment, String guardianship,
            String personalHelper, String personalHelperPowerOfAttorney, String citizenRights,
            boolean citizenInformedElectronic, boolean consent, String consentType,
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune);

    public void addEmployee();

    public void deleteEmployee();

    public IPerson getPerson(long CPR);
    
    public ICase getCase(int caseID);
}
