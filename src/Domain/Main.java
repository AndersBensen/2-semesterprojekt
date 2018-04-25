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

// Peter og LOCS tests
/*
        PersistanceContact pc;
        pc = PersistanceContact.getInstance();
        IReader reader = new ReadTXT();
        IWriter writer = new WriteTXT();
         pc.injectReader(reader);
         pc.injectWriter(writer);
         
         
         
         
         CaseRequest cr = new CaseRequest(pc.getCurrentCaseRequestID(), 1, 1007951010);
         CaseRequest cr1 = new CaseRequest(pc.getCurrentCaseRequestID(), 1, 1007951010);
         cr.setCarePackageRequested(true);
         cr.setCitizenInformed(true);
         cr.setDescription("Descri");
         cr.setMessageClear(true);
         cr.setRehousingPackageRequested(false);
         cr.setRequestPerson("mommy");
         cr.setCitizenPhoneNr(88888888);
         
         Case c = new Case(pc.getCurrentCaseID(), cr.getID());
         c.setCaseRequestID(300);
         
         writer.writeCase(c);
         writer.writeCaseRequest(cr);
         
         ICase casesss = pc.getCase(1);
         System.out.println(casesss.getID() + " Is the case ID of 1");
         
         */
         
         
    }

}
