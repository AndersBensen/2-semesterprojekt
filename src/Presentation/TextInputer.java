package Presentation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public final class TextInputer {
    
    List<String> information;
    Scanner input;
    
    public TextInputer() {
        input = new Scanner(System.in);
        start();
    }
    
    public void start() {
        while(true) {
            information = new LinkedList();
            String command = input.next().toLowerCase();
            information.add(command);
            
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
                    //TODO: Save information to DB
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
