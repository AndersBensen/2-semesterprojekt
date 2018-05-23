package Domain;

import Acquaintance.IEmployee;

public class Employee extends Person implements IEmployee {

    // These attributes makes an employee unique compared to a person
    private int id;
    private String userName;
    private String password;

    // *******************************
    // ********* Constructors ********
    // *******************************
    public Employee(String cpr, String name, char gender, String birthDate, String address, Integer phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail);
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    // *******************************
    // *********   Getters   *********
    // *******************************
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassWord() {
        return password;
    }

    // *******************************
    // *********   Setters   *********
    // *******************************
    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
