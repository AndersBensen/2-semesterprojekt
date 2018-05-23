package Domain;

public class Admin extends Employee {

    public Admin(String cpr, String name, char gender, String birthDate, String address, Integer phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
    }

    /**
     * This method adds an emplyoee to the database. 
     * It takes the information that an employee needs and creates an object of
     * either a Secretary, SocialWorker or an Admin depending on the positionNumber
     * given. It also logs activity with a description of the activity.
     *
     * @param cpr String
     * @param name String
     * @param gender char
     * @param birthDate String
     * @param address String
     * @param phoneNumber Integer
     * @param mail String
     * @param id int
     * @param userName String
     * @param password String
     * @param positionNumber int
     * @return (int) The id of the newly created Employee. If the value is -1, the 
     * employee was not created correctly and therefore wasn't saved in the database
     */
    public int addEmployee(String cpr, String name, char gender, String birthDate, String address,
            Integer phoneNumber, String mail, int id, String userName, String password, int positionNumber) {
        
        int returnInt = -1;
        
        Employee e;
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        switch (positionNumber) {
            case 1:
                e = new Secretary(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
                returnInt = pc.saveEmployee(e);
                break;
            case 2:
                e = new SocialWorker(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
                returnInt = pc.saveEmployee(e);
                break;
            case 3:
                e = new Admin(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
                returnInt = pc.saveEmployee(e);
                break;
            default:
                System.out.println("Please enter a number between 1 and 3");
        }
        pc.logAction(dc.getCurrentUser().getId(), LogAction.SAVE_EMPLOYEE, "Added employee with id: " + id + " to persistence.");
        
        return returnInt;
    }

    /**
     * This method deletes an employee with the matching employee id.
     * It removes the employee with the given id from the database and logs the 
     * activity with a description of what happened.
     * 
     * @param id int
     * @return (int) The id of the deleted Employee. If the value is -1, the employee 
     * was not deleted correctly and therefore wasn't removed from the database
     */
    public int deleteEmployee(int id) {
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        int returnInt = pc.deleteEmployee(id);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.DELETE_EMPLOYEE, "Deleted employee with id: " + id + " from persistence.");
        
        return returnInt;
    }
}
