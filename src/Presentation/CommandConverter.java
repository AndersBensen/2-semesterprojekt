package Presentation;

import Acquaintance.IDomainContact;
import java.util.Date;

public class CommandConverter {

    private IDomainContact domainContact;

    public void injectDomainContact(IDomainContact domainContact) {
        this.domainContact = domainContact;
    }

    public void performCommand(String command, String... args) {
        switch (command) {
            case "caserequest":
                try {
                    String citizenCPR = args[0];
                    String citizenName = args[1];
                    char citizenGender = args[2].charAt(0);
                    String citizenBirthdate = args[3];
                    String citizenAddress = args[4];
                    Integer citizenPhoneNr = args[5].trim().equals("")? -1 : Integer.parseInt(args[5]);
                    String citizenMail = args[6];
                    String desc = args[7];
                    boolean messageClear = getBooleanFromInput(args[8]);
                    boolean carePackageRequested = getBooleanFromInput(args[9]);
                    boolean rehousingPackageRequested = getBooleanFromInput(args[10]);
                    String requestPerson = args[11];
                    boolean citizenInformed = getBooleanFromInput(args[12]);

                    domainContact.createCaseRequest(citizenCPR, citizenName, citizenGender, citizenBirthdate, citizenAddress, citizenPhoneNr, citizenMail, desc, messageClear, carePackageRequested, rehousingPackageRequested, requestPerson, citizenInformed);
                } catch (NumberFormatException e) {
                    System.out.println("Method performCommand 'CaseRequest': NUMBER FORMAT EXCEPTION");
                }
                break;
            case "case":
                try {
                    Integer caseRequestID = Integer.parseInt(args[0]);
                    String nextAppointment = args[1];
                    String guardianship = args[2];
                    String personalHelper = args[3];
                    String personalHelperPowerOfAttorney = args[4];
                    String citizenRights = args[5];
                    boolean citizenInformedElectronic = getBooleanFromInput(args[6]);
                    boolean consent = getBooleanFromInput(args[7]);
                    String consentType = args[8];
                    String[] collectCitizenInfo = args[9].split("#");
                    String specialCircumstances = args[10];
                    String differentCommune = args[11];

                    domainContact.createCase(caseRequestID, nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent, consentType, collectCitizenInfo, specialCircumstances, differentCommune);
                } catch (NumberFormatException e) {
                    System.out.println("Method performCommand 'Case': NUMBER FORMAT EXCEPTION");
                }
                break;
            case "editcase":
                try {
                    Integer caseID = Integer.parseInt(args[0]);
                    Integer employeeID = Integer.parseInt(args[1]);
                    Integer caseRequestID = Integer.parseInt(args[2]);
                    String nextAppointment = args[3];
                    String guardianship = args[4];
                    String personalHelper = args[5];
                    String personalHelperPowerOfAttorney = args[6];
                    String citizenRights = args[7];
                    boolean citizenInformedElectronic = getBooleanFromInput(args[8]);
                    boolean consent = getBooleanFromInput(args[9]);
                    String consentType = args[10];
                    String[] collectCitizenInfo = args[11].split("#");
                    String specialCircumstances = args[12];
                    String differentCommune = args[13];
                    Date dateCreated = new Date(Long.parseLong(args[14]));

                    domainContact.saveEditedCase(caseID, employeeID, caseRequestID, nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent, consentType, collectCitizenInfo, specialCircumstances, differentCommune, dateCreated);
                } catch (NumberFormatException e) {
                    System.out.println("Method performCommand 'EditCase': NUMBER FORMAT EXCEPTION");
                }
                break;
            case "addemployee":
                try {
                    String employeeCPR = args[0];
                    String employeeName = args[1];
                    char employeeGender = args[2].charAt(0);
                    String employeeBirthdate = args[3];
                    String employeeAddress = args[4];
                    Integer employeePhoneNr = args[5].equals("") ? null : Integer.parseInt(args[5]);
                    String employeeMail = args[6];
                    String username = args[7];
                    String password = args[8];
                    int positionNumber = Integer.parseInt(args[9]);

                    domainContact.addEmployee(employeeCPR, employeeName, employeeGender, employeeBirthdate, employeeAddress, employeePhoneNr, employeeMail, username, password, positionNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Method performCommand 'AddEmployee': NUMBER FORMAT EXCEPTION");
                }
                break;
            case "deleteemployee":
                try {
                    int employeeID = Integer.parseInt(args[0]);

                    domainContact.deleteEmployee(employeeID);
                } catch (NumberFormatException e) {
                    System.out.println("Method performCommand 'DeleteEmployee': NUMBER FORMAT EXCEPTION");
                }
                break;
            case "login":
                String username = args[0];
                String password = args[1];

                domainContact.login(username, password);
                break;
            case "logout":
                domainContact.logout();
                break;
        }
    }

    private boolean getBooleanFromInput(String input) {
        if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("true")) {
            return true;
        } else if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("false")) {
            return false;
        } else {
            System.out.println("Method getBooleanFromInput: CANNOT CONVERT STRING TO BOOLEAN");
            return false;
        }
    }
}
