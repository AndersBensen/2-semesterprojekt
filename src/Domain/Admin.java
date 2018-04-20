/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ander
 */
public class Admin extends Employee{
    ArrayList<Employee> al = new ArrayList<>();
    
    public Admin(int cpr, String name, char gender, String birthDate, String address, int phoneNumber, String mail, int id, String userName, String password) {
        super(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
    }
    
    public void addEmployee(int cpr, String name, char gender, String birthDate, String address, int phoneNumber, String mail, int id, String userName, String password, int securityLevel) {
        Employee e;
        switch (securityLevel) {
            case 1:
                e = new Secretary(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
                al.add(e);
                break;
            case 2:
                e = new SocialWorker(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
                al.add(e);
                break;
            case 3:
                e = new Admin(cpr, name, gender, birthDate, address, phoneNumber, mail, id, userName, password);
                al.add(e);
                break;
            default:
                System.out.println("Security level must be between 1 and 3.");
                break;
        }
    }
    
    public void deleteEmployee(int id) {
        List<Employee> toRemove = new ArrayList<>();
        for (Employee employee : al) {
            if (id == employee.getId()) {
                toRemove.add(employee);
            }
        }
        al.removeAll(toRemove);
    }
    
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < al.size(); i++) {
            s += al.get(i).getAddress() + "\n";
            s += al.get(i).getBirthDate() + "\n";
            s += al.get(i).getCpr()+ "\n";
            s += al.get(i).getId()+ "\n";
            s += al.get(i).getMail()+ "\n";
            s +=  al.get(i).getName()+ "\n";
            s += al.get(i).getPassWord()+ "\n";
            s +=al.get(i).getPhoneNumber()+ "\n";
            s += al.get(i).getGender()+ "\n";
            s += al.get(i).getUserName()+ "\n";
        }
        return s; 
    }
}
