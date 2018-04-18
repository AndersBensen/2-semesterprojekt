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

        // IWriter writer = "anders og josef"
        //  pc.injectWriter(writer);

        Admin a = new Admin(0000, "Loc Hansen", 'M', "15-09-1998", "Munkevej 15, 5000 Odense N", 20010203, "loc@mail.dk", 1, "LH01", "password", 3);
        
        a.addEmployee(1123, "Peter Hansen", 'M', "16-10-1998", "Munkevej 16, 5000 Odense N", 20010204, "peter@mail.dk", 2, "PH02", "password", 2);

        System.out.println(a.toString());
        a.deleteEmployee(2);
        System.out.println(a.toString());
    }

}
