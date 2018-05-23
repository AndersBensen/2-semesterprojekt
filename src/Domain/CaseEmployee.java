package Domain;

import java.util.List;

public class CaseEmployee extends Employee {

    public CaseEmployee(String cpr, String name, char gender, String birthDate, String address, Integer phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
    }

    /**
     * This method sends a case request to the database.
     * It takes the information that a case request needs and create an instance
     * of it and sends it to the database. It also logs activity with a
     * description of the activity.
     *
     * @param caseRequestID int
     * @param EmployeeID int
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
     * @param contact String
     * @param isCitizenInformed boolean
     * @return (int) The id of the newly created CaseRequest. If the value is -1,
     * a case request was not created correctly and therefore wasn't saved in
     * the database
     */
    public int createCaseRequest(int caseRequestID, int EmployeeID, String citizenCPR, String citizenName, char citizenGender, String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr, String citizenMail, String desc, boolean isMessageClear, String[] carePackage, String rehousingPackage, String contact, boolean isCitizenInformed) {
        
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        
        Person citizen = new Person(citizenCPR, citizenName, citizenGender, citizenBirthdate, citizenAddress, citizenPhoneNr, citizenMail);
        CaseRequest CR = new CaseRequest(caseRequestID, EmployeeID, citizen);
        CR.setDescription(desc);
        CR.setMessageClear(isMessageClear);
        CR.setCarePackageRequested(carePackage);
        CR.setRehousingPackageRequested(rehousingPackage);
        CR.setRequestPerson(contact);
        CR.setCitizenInformed(isCitizenInformed);
        int returnInt = pc.saveCaseRequest(CR);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.SAVE_CASE_REQUEST, "Saved a case request");
        
        return returnInt;
    }
    
    /**
     * This method is used to retrieve all cases and case requests as
     * CaseObjects that affect a citizen with the specific CPR.
     * @param citizenCPR String
     * @return (List<CaseObject) Returns all the CaseObjects that responds to
     * the citizen's CPR
     */
    public List<CaseObject> getCaseObjects(String citizenCPR) {
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        
        pc.logAction(dc.getCurrentUser().getId(), LogAction.GET_CASE_OBJECT, "Requested a case object for: " + citizenCPR);
        return pc.getCaseObject(citizenCPR);
    }
}
