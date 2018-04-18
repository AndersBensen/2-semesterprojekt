/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;

/**
 *
 * @author ander
 */
public class Employee extends Citizen implements IEmployee{
    private int id; 
    private String userName;
    private String password; 
    private int securityLevel; 
    
    public Employee(long cpr, String name, char gender, String birthDate, String address, int phoneNumber, String mail, int id, String userName, String password, int securityLevel) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail);
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.securityLevel = securityLevel;
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
    
    @Override
    public int getSecurityLevel() {
        return securityLevel;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }
}
