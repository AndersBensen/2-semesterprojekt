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
public class Employee extends Person implements IEmployee{
    /**
     * Below is some attributes that make Employees unique compared to Persons. 
     */
    private int id; 
    private String userName;
    private String password; 
    
    public Employee(long cpr, String name, char gender, String birthDate, String address, int phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail);
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    
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
