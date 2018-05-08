/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Domain.DomainContact;
import Domain.IDomainContact;
import Domain.PersistanceContact;
import Acquaintance.IReader;
import Acquaintance.IWriter;
import Persistence.ReadTXT;
import Persistence.WriteTXT;
import Presentation.CommandConverter;
import Presentation.TextInputer;

/**
 *
 * @author ander
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersistanceContact PC = PersistanceContact.getInstance();

        IReader reader = new ReadTXT();
        IWriter writer = new WriteTXT();

        PC.injectReader(reader);
        PC.injectWriter(writer);
        
        CommandConverter CC = new CommandConverter();
        IDomainContact IDC = DomainContact.getInstance();
        CC.injectDomainContact(IDC);
        TextInputer TI = new TextInputer(CC, IDC);
        TI.start();
//         
//        String[] p = pc.getReader().getEmployee(1);
//        for (int i = 0; i<9; i++){
//          
//            System.out.println(p[i]);
//        }
//        
//        IEmployee e = new Employee(1000950000, "Morten", 'M', "10-01-0000", "Hejsavej", 88888888, "hej@nal.mail", 6, "Loc", "1234567");
//         
//         pc.getWriter().writeEmployee(e);
//         
//          String[] p1 = pc.getReader().getEmployee(6);
//        for (int i = 0; i<9; i++){
//          
//            System.out.println(p1[i]);
//        }

        /*
        Admin a = new Admin(0000, "Loc Hansen", 'M', "15-09-1998", "Munkevej 15, 5000 Odense N", 20010203, "loc@mail.dk", 1, "LH01", "password", 3);

        // IWriter writer = "anders og josef"
        //  pc.injectWriter(writer);

        Admin a = new Admin(0000, "Loc Hansen", 'M', "15-09-1998", "Munkevej 15, 5000 Odense N", 20010203, "loc@mail.dk", 1, "LH01", "password");

        
        a.addEmployee(1123, "Peter Hansen", 'M', "16-10-1998", "Munkevej 16, 5000 Odense N", 20010204, "peter@mail.dk", 2, "PH02", "password", 3);

        System.out.println(a.toString());
        a.deleteEmployee(2);
        System.out.println(a.toString());
         */
    }

}
