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
                String desc = args[1];
                boolean messageClear = getBooleanFromInput(args[2]);
                boolean carePackageRequested = getBooleanFromInput(args[3]);
                boolean rehousingPackageRequested = getBooleanFromInput(args[4]);
                String requestPerson = args[5];
                boolean citizenInformed = getBooleanFromInput(args[6]);
                String citizenName = args[7];
                char citizenGender = args[8].charAt(0);
                String citizenBirthdate = args[9];
                String citizenAddress = args[10];
                Integer citizenPhoneNr = Integer.parseInt(args[11]);
                String citizenMail = args[12];
                domainContact.saveCaseRequest(citizenCPR, desc, messageClear, carePackageRequested, rehousingPackageRequested, requestPerson, citizenInformed, citizenName, citizenGender, citizenBirthdate, citizenAddress, citizenPhoneNr, citizenMail);
                } catch (NumberFormatException e) {
                e.printStackTrace();
                }
                break;
            case "case":
                break;
            case "addEmployee":
                break;
            case "deleteEmployee":
                break;
        }
    }
    
    private boolean getBooleanFromInput(String input) {
        if(input.equalsIgnoreCase("Y")) {
            return true;
        }
        else if (input.equalsIgnoreCase("N")) {
            return false;
        }
        else {
            throw new Error("Could not convert input to boolean");
        }
    }
}
