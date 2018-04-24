/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Persistence.IReader;
import Persistence.IWriter;
import Persistence.ReadTXT;
import Persistence.WriteTXT;
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
        


         IReader reader = new ReadTXT();
         IWriter writer = new WriteTXT();
         
         pc.injectReader(reader);
         pc.injectWriter(writer);
         
         CaseRequest cr = new CaseRequest(100, 1, 1007951010);
         cr.setCarePackageRequested(true);
         cr.setCitizenInformed(true);
         cr.setDescription("Descri");
         cr.setMessageClear(true);
         cr.setRehousingPackageRequested(false);
         cr.setRequestPerson("mommy");
         
         Case c = new Case(cr.getID());
       
         
         writer.writeCase(c);
         writer.writeCaseRequest(cr);
         
         String[] casess = reader.getCase(500);
         String[] crs = reader.getCaseRequest(100);
         int i = 0;
         for(String s : casess){
             System.out.println(s + " " + i++);
         }
         System.out.println("-------------");
         i =0;
          for(String s : crs){
             System.out.println(s+ " " + i++);
         }
         
         
         
         /*
        String[] p = pc.getReader().getEmployee(1);
        for (int i = 0; i<9; i++){
          
            System.out.println(p[i]);
        }
        
        IEmployee e = new Employee(1000950000, "Morten", 'M', "10-01-0000", "Hejsavej", 88888888, "hej@nal.mail", 6, "Loc", "1234567");
         
         pc.getWriter().writeEmployee(e);
         
          String[] p1 = pc.getReader().getEmployee(6);
        for (int i = 0; i<9; i++){
          
            System.out.println(p1[i]);
        }
         */
         
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
