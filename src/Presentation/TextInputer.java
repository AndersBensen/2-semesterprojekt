package Presentation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public final class TextInputer {
    
    private List<String> information;
    private Scanner input;
    private CommandConverter CC;
    
    public TextInputer(CommandConverter CC) {
        input = new Scanner(System.in);
        this.CC = CC;
        start();
    }
    
    public void start() {
        while(true) {
            information = new LinkedList();
            System.out.println("\nEnter a valid command:\n");
            String command = input.nextLine().toLowerCase();
            
            switch(command) {
                case "caserequest":
                    askQuestion("CPR number of the patient?");
                    askQuestion("Name of the patient?");
                    askQuestion("Gender of the patient?");
                    askQuestion("Birthdate of the patient?");
                    askQuestion("Address of the patient?");
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
}
