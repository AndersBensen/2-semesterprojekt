package Domain;

import Acquaintance.IPerson;
import Acquaintance.IDomainContact;
import Acquaintance.ICase;

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
        this.currentUser = null; //new SocialWorker(1000950000, "Morten", 'M', "10-01-0000", "Hejsavej", 88888888, "hej@nal.mail", 6, "Loc", "1234567");
    }

    @Override
    public void createCaseRequest(long citizenCPR, String desc, boolean isMessageClear, boolean isCarePackage, boolean isRehousingPackage, String requestPerson, boolean isCitizenInformed, String citizenName, char citizenGender, String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr, String citizenMail) {
        if (currentUser instanceof CaseEmployee) {
            CaseEmployee caseEmployee = (CaseEmployee) currentUser;
            caseEmployee.createCaseRequest(PersistanceContact.getInstance().getNewCaseRequestID(), currentUser.getId(), citizenCPR, desc, isMessageClear, isCarePackage, isRehousingPackage, requestPerson, isCitizenInformed, citizenName, citizenGender, citizenBirthdate, citizenAddress, citizenPhoneNr, citizenMail);
        }
        else
            printUnauthorizedAccess("createCaseRequest");
    }

    @Override
    public void createCase(int caseRequestID, String nextAppointment, String guardianship, String personalHelper, String personalHelperPowerOfAttorney, String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType, String[] collectCitizenInfo, String specialCircumstances, String differentCommune) {
        if (currentUser instanceof SocialWorker) {
            SocialWorker socialWorker = (SocialWorker) currentUser;
            socialWorker.saveCase(PersistanceContact.getInstance().getNewCaseID(), caseRequestID, nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent, consentType, collectCitizenInfo, specialCircumstances, differentCommune);
        }
        else
            printUnauthorizedAccess("createCase");
    }
    
    @Override
    public void saveEditedCase(int caseID, int caseRequestID, String nextAppointment, String guardianship, String personalHelper, String personalHelperPowerOfAttorney, String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType, String[] collectCitizenInfo, String specialCircumstances, String differentCommune) {
        if (currentUser instanceof SocialWorker) {
            SocialWorker socialWorker = (SocialWorker) currentUser;
            socialWorker.saveCase(caseID, caseRequestID, nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent, consentType, collectCitizenInfo, specialCircumstances, differentCommune);
        }
        else
            printUnauthorizedAccess("saveEditedCase");
    }

    @Override
    public void addEmployee(long CPR, String name, char gender, String birthdate, String Address,
            Integer phoneNr, String mail, String username, String password, int positionNumber) {
        if (currentUser instanceof Admin) {
            Admin admin = (Admin) currentUser;
            admin.addEmployee(CPR, name, gender, birthdate, Address, phoneNr, mail, PersistanceContact.getInstance().getNewEmployeeID(), username, password, positionNumber);
        }
        else
            printUnauthorizedAccess("addEmployee");
    }

    @Override
    public void deleteEmployee(int employeeID) {
        if (currentUser instanceof Admin) {
            Admin admin = (Admin) currentUser;
            admin.deleteEmployee(employeeID);
        }
        else
            printUnauthorizedAccess("deleteEmployee");
    }

    @Override
    public boolean login(String username, String password) {
        PersistanceContact PS = PersistanceContact.getInstance();
        Employee newUser = PS.login(username, password);
        if(newUser != null) {
            currentUser = newUser;
            PS.logAction(currentUser.getId(), LogAction.LOG_IN, "User succesfully logged in with username: " + username + " and the password: " + password);
            return true; 
        }
        PS.logAction(-1, LogAction.LOG_IN, "User failed to log in with username: " + username + " and the password: " + password);
        return false;
    }
    
    @Override
    public ICase getCase(int caseID) {
        return PersistanceContact.getInstance().getCase(caseID);
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
    
    private void printUnauthorizedAccess(String methodName) {
        System.out.println("User not allowed to perform command: " + methodName);
    }
}
