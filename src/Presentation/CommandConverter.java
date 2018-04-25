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

                    domainContact.saveCaseRequest(citizenCPR, desc, messageClear, carePackageRequested, rehousingPackageRequested, requestPerson, citizenInformed, citizenName, citizenGender, citizenBirthdate, citizenAddress, citizenPhoneNr, citizenMail);
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
                    
                    domainContact.saveCase(caseRequestID, nextAppointment, guardianship, personalHelper, personalHelperPowerOfAttorney, citizenRights, citizenInformedElectronic, consent, consentType, collectCitizenInfo, specialCircumstances, differentCommune);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                break;

            case "addEmployee":
                break;
            case "deleteEmployee":
                break;
        }
    }

    private boolean getBooleanFromInput(String input) {
        if (input.equalsIgnoreCase("Y")) {
            return true;
        } else if (input.equalsIgnoreCase("N")) {
            return false;
        } else {
            throw new Error("Could not convert input to boolean");
        }
    }
}
