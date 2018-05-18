package Domain;

public class Admin extends Employee {

    public Admin(String cpr, String name, char gender, String birthDate, String address, Integer phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
    }

    /**
     * The method addEmployee adds an emplyoee to the persistance layer. The
     * method takes the different attributes that a employee needs and
     * instantitates as either a Secretary, SocialWorker or an Admin depending n
     * the positionNumber given. It also logs activity with a description of the
     * activity.
     *
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
     * This method deletes an employee with the matching employee id. It also
     * logs the activity with a description of what happened.
     *
     * @param id
     */
    public int deleteEmployee(int id) {
        DomainContact dc = DomainContact.getInstance();
        PersistanceContact pc = PersistanceContact.getInstance();
        int returnInt = pc.deleteEmployee(id);
        pc.logAction(dc.getCurrentUser().getId(), LogAction.DELETE_EMPLOYEE, "Deleted employee with id: " + id + " from persistence.");
        
        return returnInt;
    }
}
