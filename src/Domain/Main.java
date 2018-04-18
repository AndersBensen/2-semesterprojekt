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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PersistanceContact pc = new PersistanceContact();
        
        
        Admin a = new Admin(0000, "Loc Hansen", "M", new Date(), "Munkevej 15, 5000 Odense N", 20010203, "loc@mail.dk", 1, "LH01", "password", 3);
        
        a.addEmployee(1123, "Peter Hansen", "M", new Date(), "Munkevej 16, 5000 Odense N", 20010204, "peter@mail.dk", 2, "PH02", "password", 2);
        System.out.println(a.toString());
        a.deleteEmployee(2);
        System.out.println(a.toString());
    }
    
}
