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
public class Secretary extends Employee{
    
    public Secretary(int cpr, String name, String sex, Date birthDate, String address, int phoneNumber, String mail, int id, String userName, String password, int securityLevel) {
        super(cpr, name, sex, birthDate, address, phoneNumber, mail, id, userName, password, securityLevel);
    }
    
}
