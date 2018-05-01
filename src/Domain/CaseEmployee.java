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
    
    /**
     * The method createCaseRequest is a method to create a case request.
     * The method takes the different arguments and creates a case request
     * and sends it to the PersistanceContact class. It also logs the 
     * activity that happens when the method is used. 
     * 
     * @param caseRequestID
     * @param EmployeeID
     * @param citizenCPR
     * @param desc
     * @param isMessageClear
     * @param isCarePackage
     * @param isRehousingPackage
     * @param contact
     * @param isCitizenInformed
     * @param citizenName
     * @param citizenGender
     * @param citizenBirthdate
     * @param citizenAddress
     * @param citizenPhoneNr
     * @param citizenMail 
     */
    public void createCaseRequest(int caseRequestID, int EmployeeID, long citizenCPR, String desc, boolean isMessageClear, boolean isCarePackage, boolean isRehousingPackage, String contact, boolean isCitizenInformed, String citizenName, char citizenGender, String citizenBirthdate, String citizenAddress, Integer citizenPhoneNr, String citizenMail) {
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance(); 
        
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
