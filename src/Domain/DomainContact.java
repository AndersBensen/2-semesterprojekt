package Domain;

import Acquaintance.IPerson;
import Acquaintance.IDomainContact;
import Acquaintance.ICase;
import Acquaintance.ICaseObject;
import Acquaintance.IEmployee;
import Acquaintance.IVisualController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DomainContact implements IDomainContact {

    private static DomainContact instance = null;
    private SystemTimer timer;
    private volatile Thread timerThread;

    public static DomainContact getInstance() {
        if (instance == null) {
            instance = new DomainContact();
        }
        return instance;
    }

    private Employee currentUser;

    private DomainContact() {
        this.currentUser = null;
    }

    @Override
    public int createCaseRequest(String citizenCPR, String citizenName, char citizenGender,
            String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr,
            String citizenMail, String desc, boolean isMessageClear, String[] carePackage,
            String rehousingPackage, String requestPerson, boolean isCitizenInformed) {
        
        if (userLoggedIn() && currentUser instanceof CaseEmployee) {
            CaseEmployee caseEmployee = (CaseEmployee) currentUser;
            return caseEmployee.createCaseRequest(PersistanceContact.getInstance().getNewCaseRequestID(),
                    currentUser.getId(), citizenCPR, citizenName, citizenGender, citizenBirthdate,
                    citizenAddress, citizenPhoneNr, citizenMail, desc, isMessageClear, carePackage,
                    rehousingPackage, requestPerson, isCitizenInformed);
        } else {
            printUnauthorizedAccess("createCaseRequest");
        }
        return -1;
    }

    @Override
    public int createCase(int caseRequestID, String nextAppointment, String guardianship,
            String personalHelper, String personalHelperPowerOfAttorney, String citizenRights,
            boolean citizenInformedElectronic, boolean consent, String consentType, String[] collectCitizenInfo,
            String specialCircumstances, String differentCommune, String state) {
        
        if (userLoggedIn() && currentUser instanceof SocialWorker) {
            SocialWorker socialWorker = (SocialWorker) currentUser;
            return socialWorker.saveCase(PersistanceContact.getInstance().getNewCaseID(),
                    currentUser.getId(), caseRequestID, nextAppointment, guardianship, personalHelper,
                    personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent,
                    consentType, collectCitizenInfo, specialCircumstances, differentCommune, state);
        } else {
            printUnauthorizedAccess("createCase");
        }
        return -1;
    }
    
    @Override
    public ICase editCase(int caseID) {
        if (userLoggedIn() && currentUser instanceof SocialWorker) {
            SocialWorker socialWorker = (SocialWorker) currentUser;
            return socialWorker.editCase(caseID);
        } else {
            printUnauthorizedAccess("editCase");
        }
        return null; 
    }

    @Override
    public int saveEditedCase(int caseID, int employeeID, int caseRequestID, String nextAppointment,
            String guardianship, String personalHelper, String personalHelperPowerOfAttorney,
            String citizenRights, boolean citizenInformedElectronic, boolean consent, String consentType,
            String[] collectCitizenInfo, String specialCircumstances, String differentCommune, String state, Date dateCreated) {
        
        if (userLoggedIn() && currentUser instanceof SocialWorker) {
            SocialWorker socialWorker = (SocialWorker) currentUser;
            return socialWorker.saveEditedCase(caseID, employeeID, caseRequestID,
                    nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney,
                    citizenRights, citizenInformedElectronic, consent, consentType,
                    collectCitizenInfo, specialCircumstances, differentCommune, state, dateCreated);
        } else {
            printUnauthorizedAccess("saveEditedCase");
        }
        return -1;
    }

    @Override
    public int addEmployee(String CPR, String name, char gender, String birthdate, String Address,
            Integer phoneNr, String mail, String username, String password, int positionNumber) {
        
        if (userLoggedIn() && currentUser instanceof Admin) {
            Admin admin = (Admin) currentUser;
            return admin.addEmployee(CPR, name, gender, birthdate, Address, phoneNr, mail,
                    PersistanceContact.getInstance().getNewEmployeeID(), username, password, positionNumber);
        } else {
            printUnauthorizedAccess("addEmployee");
        }
        return -1;
    }

    @Override
    public int deleteEmployee(int employeeID) {
        if (userLoggedIn() && currentUser instanceof Admin) {
            Admin admin = (Admin) currentUser;
            return admin.deleteEmployee(employeeID);
        } else {
            printUnauthorizedAccess("deleteEmployee");
        }
        return -1;
    }

    @Override
    public boolean login(String username, String password) {
        PersistanceContact PS = PersistanceContact.getInstance();
        Employee newUser = PS.login(username, password);
        if (newUser != null) {
            currentUser = newUser;
            PS.logAction(currentUser.getId(), LogAction.LOG_IN,
                    "User succesfully logged in with username: " + username + " and the password: " + password);
            return true;
        }
        PS.logAction(-1, LogAction.LOG_IN,
                    "User failed to log in with username: " + username + " and the password: " + password);
        return false;
    }

    @Override
    public boolean logout() {
        if (userLoggedIn()) {
            PersistanceContact PS = PersistanceContact.getInstance();
            PS.logAction(currentUser.getId(), LogAction.LOG_OUT,
                    "User with username: " + currentUser.getUserName()
                    + " and the password: " + currentUser.getPassWord() + " succesfully logged out");
            this.currentUser = null;
            timerThread = null;
            return true;
        } else {
            System.out.println("You failed to log out: No user is logged in.");
        }
        return false;
    }

    @Override
    public void injectVisualController(IVisualController IVC) {
        timer = new SystemTimer();
        timer.injectVisualController(IVC);
        
        //Initialize timerthread
        timerThread = new Thread(timer);
        timer.injectTimerThread(timerThread);
        timerThread.start();
    }

    @Override
    public void resetTimer() {
        timer.resetTimer();
    }

    @Override
    public boolean authorizeCommand(String command) {
        boolean authorized = false;

        switch (command) {
            case "caserequest":
                if (userLoggedIn() && currentUser instanceof CaseEmployee) {
                    authorized = true;
                }
                break;
            case "case":
                if (userLoggedIn() && currentUser instanceof SocialWorker) {
                    authorized = true;
                }
                break;
            case "editcase":
                if (userLoggedIn() && currentUser instanceof SocialWorker) {
                    authorized = true;
                }
                break;
            case "addemployee":
                if (userLoggedIn() && currentUser instanceof Admin) {
                    authorized = true;
                }
                break;
            case "deleteemployee":
                if (userLoggedIn() && currentUser instanceof Admin) {
                    authorized = true;
                }
                break;
            case "searchperson":
                if (userLoggedIn() && currentUser instanceof CaseEmployee) {
                    authorized = true;
                }
                break;
            default:
                System.out.println("AuthorizedCommand: Invalid command to authorized");
        }

        if (!authorized) {
            System.out.println("User not authorized for command: " + command);
        }

        return authorized;
    }

    @Override
    public List<ICaseObject> getCaseObject(String citizenCPR) {
        List<ICaseObject> iCaseObjectList = new ArrayList<>();
        boolean isSecretary = false; 
        
        if (userLoggedIn() && currentUser instanceof CaseEmployee) {
            CaseEmployee caseEmployee = (CaseEmployee) currentUser;
            if (currentUser instanceof Secretary) {
                isSecretary = true; 
            }
            for (ICaseObject iCaseObject : caseEmployee.getCaseObjects(citizenCPR)) {
                if (isSecretary) {
                    if (iCaseObject.getType().equalsIgnoreCase("caserequest")) {
                        iCaseObjectList.add(iCaseObject);
                    }
                }
                else {
                    iCaseObjectList.add(iCaseObject);
                }
            }
        }
        else {
            printUnauthorizedAccess("getCaseObject");
        }
        
        return iCaseObjectList;
    }

    @Override
    public IPerson getPerson(String CPR) {
        if (!userLoggedIn()) {
            printUnauthorizedAccess("getPerson");
            return null;
        }
        PersistanceContact PS = PersistanceContact.getInstance();
        PS.logAction(currentUser.getId(), LogAction.GET_PERSON,
                "User requested for a person with CPR: " + CPR);
        return PS.getPerson(CPR);
    }

    @Override
    public IEmployee getEmployee(int ID)
    {
        if (!userLoggedIn()) {
            printUnauthorizedAccess("getEmployee");
            return null;
        }
        PersistanceContact PS = PersistanceContact.getInstance();
        PS.logAction(currentUser.getId(), LogAction.GET_EMPLOYEE,
                "User requested for an employee with ID: " + ID);
        return PS.getEmployee(ID);
    }

    @Override
    public Employee getCurrentUser() {
        return currentUser;
    }

    private boolean userLoggedIn() {
        return currentUser != null;
    }

    private void printUnauthorizedAccess(String methodName) {
        System.out.println("User not allowed to perform command: " + methodName);
    }
}
