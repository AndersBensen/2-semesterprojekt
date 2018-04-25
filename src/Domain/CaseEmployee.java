/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author ander
 */
public class CaseEmployee extends Employee{

    public CaseEmployee(long cpr, String name, char gender, String birthDate, String address, int phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
    }
    
    public void createCaseRequest(int caseRequestID, int EmployeeID, long citizenCPR, String desc, boolean isMessageClear, boolean isCarePackage, boolean isRehousingPackage, String contact, boolean isCitizenInformed, String citizenName, char citizenGender, String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr, String citizenMail) {
        CaseRequest CR = new CaseRequest(caseRequestID, EmployeeID, citizenCPR);
        CR.setDescription(desc);
        CR.setMessageClear(isMessageClear);
        CR.setCarePackageRequested(isCarePackage);
        CR.setRehousingPackageRequested(isRehousingPackage);
        CR.setCitizenInformed(isCitizenInformed);
        CR.connectCitizen(citizenCPR, citizenName, citizenGender, citizenBirthdate, citizenAddress);
        if(citizenPhoneNr != null) {
            CR.setCitizenPhoneNr(citizenPhoneNr);
        }
        if(citizenMail != null) {
            CR.setCitizenMail(citizenMail);
        }
        pc.saveCaseRequest(CR);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.SAVE_CASE_REQUEST, "Saved a case request");
    }
}
