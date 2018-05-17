package Domain;

import java.util.List;

public class CaseEmployee extends Employee {

    public CaseEmployee(String cpr, String name, char gender, String birthDate, String address, Integer phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
    }

    /**
     * The method createCaseRequest is a method to create a case request. The
     * method takes the different arguments and creates a case request and sends
     * it to the PersistanceContact class. It also logs the activity that
     * happens when the method is used.
     *
     * @param caseRequestID
     * @param EmployeeID
     * @param citizenCPR
     * @param desc
     * @param isMessageClear
     * @param carePackage
     * @param rehousingPackage
     * @param contact
     * @param isCitizenInformed
     * @param citizenName
     * @param citizenGender
     * @param citizenBirthdate
     * @param citizenAddress
     * @param citizenPhoneNr
     * @param citizenMail
     */
    public void createCaseRequest(int caseRequestID, int EmployeeID, String citizenCPR, String citizenName, char citizenGender, String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr, String citizenMail, String desc, boolean isMessageClear, String[] carePackage, String rehousingPackage, String contact, boolean isCitizenInformed) {
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
        pc.saveCaseRequest(CR);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.SAVE_CASE_REQUEST, "Saved a case request");
    }
    
    public List<CaseObject> getCaseObjects(String citizenCPR) {
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        
        pc.logAction(dc.getCurrentUser().getId(), LogAction.GET_CASE_OBJECT, "Requested a case object for: " + citizenCPR);
        return pc.getCaseObject(citizenCPR);
    }
}
