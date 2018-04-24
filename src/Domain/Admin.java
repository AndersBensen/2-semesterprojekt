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
public class Admin extends Employee{
    private PersistanceContact ps;
    
    public Admin(long cpr, String name, char gender, String birthDate, String address, int phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
        ps = PersistanceContact.getInstance();
    }
    
    /**
     * The method below belongs in the presentation layer. 
     * @param cpr
     * @param name
     * @param gender
     * @param birthDate
     * @param address
     * @param phoneNumber
     * @param mail
     * @param id
     * @param userName
     * @param password
     * @param positionNumber 
     */
//    public void findPerson(long cpr) {
//        String[] person = ps.getReader().getPerson(cpr); 
//        long cprFromPerson = Long.parseLong(person[0]);
//        String nameFromPerson = person[1];
//        char genderFromPerson = person[2].charAt(0);
//        String birthDateFromPerson = person[3];
//        String addressFromPerson = person[4];
//        
//        System.out.println("CPR: " + cprFromPerson + ", name: " + nameFromPerson + ", gender: " + genderFromPerson + ", birthdate: " + birthDateFromPerson + ", address: " + addressFromPerson);
//        
//        Scanner input = new Scanner(System.in);
//        
//        System.out.println("Please enter the employees phonenumber: ");
//        int phoneNumber = input.nextInt();
//        System.out.println("Please enter the employees mail: ");
//        String mail = input.nextLine();
//        System.out.println("Please enter the employees id: ");
//        int id = input.nextInt();
//        System.out.println("Please enter the employees user name: ");
//        String userName = input.nextLine();
//        System.out.println("Please enter the employees password: ");
//        String password = input.nextLine();
//        System.out.println("Is the employee a Secretary (press 1), Social worker (press 2) or a Admin? (press 3)");
//        int positionNumber = input.nextInt();
//        
//        addEmployee(cprFromPerson, nameFromPerson, genderFromPerson, birthDateFromPerson, addressFromPerson, phoneNumber, mail, id, userName, password, positionNumber);
//    }
    
    public void addEmployee(long cpr, String name, char gender, String birthDate, String address, int phoneNumber, String mail, int id, String userName, String password, int positionNumber) {
        IEmployee e;
        switch (positionNumber) {
            case 1: 
                e = new Secretary(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
                ps.saveEmployee(e);
                break;
            case 2:
                e = new SocialWorker(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
                ps.saveEmployee(e);
                break;
            case 3:
                e = new Admin(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
                ps.saveEmployee(e);
                break;
            default: 
                System.out.println("Please enter a number between 1 and 3");
        }
        ps.logAction(2, LogAction.SAVE_EMPLOYEE, "Added employee to persistance layer");
    }
    
    public void deleteEmployee(int id) {
        ps.deleteEmployee(id);
    }
}
