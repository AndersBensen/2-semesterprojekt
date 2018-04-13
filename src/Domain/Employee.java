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
public class Employee extends Citizen {
    private int id; 
    private String userName;
    private String password; 
    private int securityLevel; 
    
    public Employee(int cpr, String name, String sex, Date birthDate, String address, int phoneNumber, String mail, int id, String userName, String password, int securityLevel) {
        super(cpr, name, sex, birthDate, address, phoneNumber, mail);
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.securityLevel = securityLevel;
    }
    
    public int getId() {
        return id; 
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassWord() {
        return password;
    }
    
    public int getSecurityLevel() {
        return securityLevel;
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

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }
    
}
