package Presentation;

import Domain.IDomainContact;
import Domain.IPerson;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class TextInputer {

    private List<String> information;
    private Scanner input;
    private CommandConverter CC;
    private IDomainContact IDC;

    public TextInputer(CommandConverter CC, IDomainContact IDC) {
        input = new Scanner(System.in);
        this.CC = CC;
        this.IDC = IDC;
        start();
    }

    public void start() {
        while (true) {
            information = new LinkedList();
            System.out.println("\nEnter a valid system command (caserequest | case | editcase | addemployee | deleteemployee):\n");
            String command = input.nextLine().toLowerCase();

            switch (command) {
                case "caserequest":
                    askQuestion("CPR number of the patient?");
                    IPerson person = IDC.getPerson(Long.parseLong(information.get(0)));
                    if (person != null) {
                        information.add(person.getName());
                        information.add(Character.toString(person.getGender()));
                        information.add(person.getBirthDate());
                        information.add(person.getAddress());
                    } else {
                        askQuestion("Name of the patient?");
                        askQuestion("Gender of the patient?");
                        askQuestion("Birthdate of the patient?");
                        askQuestion("Address of the patient?");
                    }
                    askQuestion("Phone number of the patient?");
                    askQuestion("Email of the patient?");
                    askQuestion("Description of the case request");
                    askQuestion("Is message clear? (Y/N)");
                    askQuestion("Is care package requested? (Y/N)");
                    askQuestion("Is rehousing package requested? (Y/N)");
                    askQuestion("Who is responsible for the case request?");
                    askQuestion("Is the citizen informed of the case request? (Y/N)");
                    CC.performCommand(command, information.toArray(new String[information.size()]));
                    break;
                case "case":
                    askQuestion("Which case request ID are you looking for?");
                    askQuestion("When is the next appointment?");
                    askQuestion("Enter type of guardianship (§5, §6, §7) - if any");
                    if (information.get(2).equalsIgnoreCase("5") || information.get(2).equalsIgnoreCase("6") || information.get(2).equalsIgnoreCase("7")) {
                        askQuestion("Enter the guardians contact information");
                        askQuestion("Descripe the correlation between guardian and citizen");
                    } else {
                        information.add("");
                        information.add("");
                    }
                    askQuestion("Is the citizen informed of his/her rights?");
                    askQuestion("Is the citizen informed electronically? (Y/N)");
                    askQuestion("Is it relevent for the citizen to give his/her consent? (Y/N)");
                    if (information.get(7).equalsIgnoreCase("Y")) {
                        askQuestion("Which type of consent?");
                    } else {
                        information.add("");
                    }
                    askForFurtherInfo();
                    askQuestion("Any special circumstances?");
                    askQuestion("Is the citizen from a different commune?");
                    CC.performCommand(command, information.toArray(new String[information.size()]));
                    break;
                case "editcase":
                    System.out.println("Which case ID are you looking for?");
                    int ID = input.nextInt();
                    System.out.println("\n" + IDC.getCase(ID));
                    reAddInfo(ID);
                    int fieldNr = 1;
                    while(fieldNr != 0) {
                        System.out.println("\nWhich field should be edited? (1,2... or 0 to exit)");
                        fieldNr = input.nextInt();
                        if(fieldNr != 0) {
                        System.out.println("Type in your edit:");
                        input.nextLine(); //virker ikke uden denne ekstra input linje???
                        String edit = input.nextLine();
                        updateField(fieldNr, edit);
                        }
                    }
                    CC.performCommand(command, information.toArray(new String[information.size()]));
                    break;
                case "addemployee":
                    break;
                case "deleteemployee":
                    break;
            }
        }
    }

    private void askQuestion(String question) {
        System.out.println(question);
        information.add(input.nextLine());
    }

    private void askForFurtherInfo() {
        String answer = "";
        StringBuilder SB = new StringBuilder();
        while (!answer.equalsIgnoreCase("x")) {
            System.out.println("Who has provided information? (write x to exit)");
            answer = input.nextLine();
            System.out.println(answer);
            if (!answer.equalsIgnoreCase("x")) {
                SB.append(answer);
                SB.append("|");
            }
        }
        SB.deleteCharAt(SB.length() - 1);
        System.out.println(SB.toString());
        information.add(SB.toString());
    }
    
    private void updateField(int fieldNr, String updatedInfo) {
        
        switch(fieldNr) {
            case 1:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 2:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 3:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 4:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 5:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 6:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 7:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 8:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 9:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 10:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;
            case 11:
                information.add(fieldNr + 1, updatedInfo);
                System.out.println("Field number: " + fieldNr + " updated with: " + updatedInfo);
                break;    
        } 
    }
    
    private void reAddInfo(int ID) {
        information.add(Integer.toString(IDC.getCase(ID).getCaseRequestID()));
        information.add(IDC.getCase(ID).getNextAppointment());
        information.add(IDC.getCase(ID).getGuardianship());
        information.add(IDC.getCase(ID).getPersonalHelper());
        information.add(IDC.getCase(ID).getPersonalHelperPowerOfAttorney());
        information.add(IDC.getCase(ID).getCitizenRights());
        information.add(Boolean.toString(IDC.getCase(ID).isCitizenInformedElectronic()));
        information.add(Boolean.toString(IDC.getCase(ID).hasConsent()));
        information.add(IDC.getCase(ID).getConsentType());
        information.add(Arrays.toString(IDC.getCase(ID).getCollectCitizenInfo()));
        information.add(IDC.getCase(ID).getSpecialCircumstances());
        information.add(IDC.getCase(ID).getDifferentCommune());
    }
}
