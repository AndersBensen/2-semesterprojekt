package Presentation;

import Domain.IDomainContact;

public class CommandConverter {

    private IDomainContact domainContact;

    public void injectDomainContact(IDomainContact domainContact) {
        this.domainContact = domainContact;
    }

    public void performCommand(String command, String... args) {
        switch (command) {
            case "caserequest":
                try {
                    long citizenCPR = Long.parseLong(args[0]);
                    String citizenName = args[1];
                    char citizenGender = args[2].charAt(0);
                    String citizenBirthdate = args[3];
                    String citizenAddress = args[4];
                    Integer citizenPhoneNr = Integer.parseInt(args[5]);
                    String citizenMail = args[6];
                    String desc = args[7];
                    boolean messageClear = getBooleanFromInput(args[8]);
                    boolean carePackageRequested = getBooleanFromInput(args[9]);
                    boolean rehousingPackageRequested = getBooleanFromInput(args[10]);
                    String requestPerson = args[11];
                    boolean citizenInformed = getBooleanFromInput(args[12]);

                    domainContact.createCaseRequest(citizenCPR, desc, messageClear, carePackageRequested, rehousingPackageRequested, requestPerson, citizenInformed, citizenName, citizenGender, citizenBirthdate, citizenAddress, citizenPhoneNr, citizenMail);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
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
                    String[] collectCitizenInfo = args[9].split("|");
                    String specialCircumstances = args[10];
                    String differentCommune = args[11];
                    
                    domainContact.createCase(caseRequestID, nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent, consentType, collectCitizenInfo, specialCircumstances, differentCommune);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                break;
            case "editcase":
                try {
                    Integer caseID = Integer.parseInt(args[0]);
                    Integer caseRequestID = Integer.parseInt(args[1]);
                    String nextAppointment = args[2];
                    String guardianship = args[3];
                    String personalHelper = args[4];
                    String personalHelperPowerOfAttorney = args[5];
                    String citizenRights = args[6];
                    boolean citizenInformedElectronic = getBooleanFromInput(args[7]);
                    boolean consent = getBooleanFromInput(args[8]);
                    String consentType = args[9];
                    String[] collectCitizenInfo = args[10].split("|");
                    String specialCircumstances = args[11];
                    String differentCommune = args[12];
                    
                    domainContact.saveEditedCase(caseID, caseRequestID, nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent, consentType, collectCitizenInfo, specialCircumstances, differentCommune);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                break;
            case "addemployee":
                try
                {
                    long employeeCPR = Long.parseLong(args[0]);
                    String employeeName = args[1];
                    char employeeGender = args[2].charAt(0);
                    String employeeBirthdate = args[3];
                    String employeeAddress = args[4];
                    Integer employeePhoneNr = args[5].equals("")? null : Integer.parseInt(args[5]);
                    String employeeMail = args[6];
                    String username = args[7];
                    String password = args[8];
                    int positionNumber = Integer.parseInt(args[9]);
                    
                    domainContact.addEmployee(employeeCPR, employeeName, employeeGender, employeeBirthdate, employeeAddress, employeePhoneNr, employeeMail, username, password, positionNumber);
                } catch (NumberFormatException e)
                {
                    e.printStackTrace();
                }
                break;
            case "deleteemployee":
                try
                {
                    int employeeID = Integer.parseInt(args[0]);
                    
                    domainContact.deleteEmployee(employeeID);
                } catch (NumberFormatException e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }

    private boolean getBooleanFromInput(String input) {
        if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("true")) {
            return true;
        } else if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("false")) {
            return false;
        } else {
            throw new Error("Could not convert input to boolean");
        }
    }
}
