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

    // *******************************
    // *********  Singleton  *********
    // *******************************
    private static DomainContact instance = null;
    public static DomainContact getInstance() {
        if (instance == null) {
            instance = new DomainContact();
        }
        return instance;
    }
    
    private DomainContact() {
        this.currentUser = null;
    }
    
    // *******************************
    // ********   Attributes  ********
    // *******************************
    
    // Information about the current system
    private Employee currentUser;
    private SystemTimer timer;
    private volatile Thread timerThread;

    /**
     * This method parses information about a new case request to the current user.
     * @param citizenCPR String
     * @param citizenName String
     * @param citizenGender char
     * @param citizenBirthdate String
     * @param citizenAddress String
     * @param citizenPhoneNr Integer
     * @param citizenMail String
     * @param desc String
     * @param isMessageClear boolean
     * @param carePackage String[]
     * @param rehousingPackage String
     * @param requestPerson String
     * @param isCitizenInformed boolean
     * @return (int) The id of the newly created CaseRequest. If the value is -1,
     * a case request was not created correctly and therefore wasn't saved in
     * the database
     */
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

    /**
     * This method parses information about a new case to the current user.
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
     * @return (int) The id of the newly created Case. If the value is -1, a 
     * case was not created correctly and therefore wasn't saved in the database
     */
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
    
    /**
     * This method ask the current user for a case with a specific id
     * @param caseID int
     * @return (ICase) The case if any with the specific id
     */
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

    /**
     * This method parses information about an existing case to the current user.
     * @param caseID int
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
     * @return (int) The id of the newly edited Case. If the value is -1, the 
     * case was not edited correctly and therefore the changes wasn't saved in
     * the database
     */
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

    /**
     * This method parses information about a new employee to the current user.
     * @param CPR String
     * @param name String
     * @param gender char
     * @param birthdate String
     * @param Address String
     * @param phoneNr Integer
     * @param mail String
     * @param username String
     * @param password String
     * @param positionNumber int
     * @return (int) The id of the newly created Employee. If the value is -1, an
     * employee was not created correctly and therefore wasn't saved in the
     * database
     */
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

    /**
     * This method prompt the current user to delete an employee with the
     * specific id.
     * @param employeeID int
     * @return (int) The id of the deleted Employee. If the value is -1, an
     * employee was not deleted correctly and therefore wasn't removed from the
     * database
     */
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

    /**
     * This method checks if the username and password matches any users in the
     * system.
     * 
     * If the information matchs, the user is logged into the system
     * @param username String
     * @param password String
     * @return (boolean) Returns whether or not a user was logged in
     */
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
        return false;
    }

    /**
     * This method logs the current user out of the system.
     * 
     * @return (boolean) Returns whether or not a user was logged out of the
     * system
     */
    @Override
    public boolean logout() {
        if (userLoggedIn()) {
            PersistanceContact PS = PersistanceContact.getInstance();
            PS.logAction(currentUser.getId(), LogAction.LOG_OUT,
                    "User with username: " + currentUser.getUserName()
                    + " and the password: " + currentUser.getPassWord() + " succesfully logged out");
            this.currentUser = null;
            timerThread = null;
            timer.clearThread();
            return true;
        } else {
            System.out.println("You failed to log out: No user is logged in.");
        }
        return false;
    }

    /**
     * This method injects a reference to the presentation layer and starts the 
     * timer thread.
     * 
     * @param IVC IVisualController
     */
    @Override
    public void injectVisualController(IVisualController IVC) {
        timer = new SystemTimer();
        timer.injectVisualController(IVC);
        
        //Initialize timerthread
        timerThread = new Thread(timer);
        timerThread.setDaemon(true);
        timer.injectTimerThread(timerThread);
        timerThread.start();
    }

    /**
     * This method tells the current timer to start over.
     */
    @Override
    public void resetTimer() {
        timer.resetTimer();
    }

    /**
     * This method is used to check if the current user is allowed to perform a 
     * specific command.
     * 
     * @param command String
     * @return (boolean) Returns whether or not the user is authorized
     */
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

    /**
     * This method is used to retrieve all cases and case requests as
     * CaseObjects that affect a citizen with the specific CPR.
     * 
     * @param citizenCPR String
     * @return (List ICaseObject) Returns all the CaseObjects that responds to
     * the citizen's CPR
     */
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
    
    /**
     * This method is used to get a person with the specific CPR.
     * 
     * @param CPR String
     * @return (IPerson) Returns the person if any with the specific CPR
     */
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

    /**
     * This method is used to get an employee with the specific id.
     * 
     * @param ID int
     * @return (IEmployee) Returns an employee if any with the specific id
     */
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
    
    /**
     * This method is used to get the current user.
     * 
     * @return (Employee) Returns the current user if any
     */
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
