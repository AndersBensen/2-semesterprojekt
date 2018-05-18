package Acquaintance;

import java.util.Date;
import java.util.List;

public interface IDomainContact {

    public int createCaseRequest(String citizenCPR, String citizenName, char citizenGender,
            String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr, String citizenMail
            , String desc, boolean isMessageClear, String[] carePackage, String rehousingPackage,
            String requestPerson, boolean isCitizenInformed);

    public int createCase(int caseRequestID, String nextAppointment, String guardianship,
            String personalHelper, String personalHelperPowerOfAttorney, String citizenRights,
            boolean citizenInformedElectronic, boolean consent, String consentType,
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune, String state);

    public int saveEditedCase(int caseID, int employeeID, int caseRequestID, String nextAppointment, String guardianship,
            String personalHelper, String personalHelperPowerOfAttorney, String citizenRights,
            boolean citizenInformedElectronic, boolean consent, String consentType,
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune, String state, Date dateCreated);

    public ICase editCase(int caseID);

    public int addEmployee(String CPR, String name, char gender, String birthdate, String Address,
            Integer phoneNr, String mail, String username, String password, int positionNumber);

    public int deleteEmployee(int employeeID);

    public boolean login(String username, String password);

    public boolean logout();
    
    public void injectVisualController(IVisualController IVC);

    public void resetTimer();

    public boolean authorizeCommand(String command);
    
    public List<ICaseObject> getCaseObject(String citizenCPR);

    public IPerson getPerson(String CPR);
    
    public IEmployee getEmployee(int ID);
    
    public IEmployee getCurrentUser();
}
