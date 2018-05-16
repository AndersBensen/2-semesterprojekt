package Starter;

import Acquaintance.IReader;
import Acquaintance.IWriter;
import Domain.DomainContact;
import Domain.PersistanceContact;
import Persistence.ReadDB;
import Persistence.WriteDB;
import Presentation.CommandConverter;
import Presentation.Sem02_Semesterprojekt_SensumUdred;
import Presentation.TextInputer;

public class Main {

    public static void main(String[] args) {
        
        PersistanceContact PC = PersistanceContact.getInstance();

        IReader reader = new ReadDB();
        IWriter writer = new WriteDB();
        
        Sem02_Semesterprojekt_SensumUdred sp = new Sem02_Semesterprojekt_SensumUdred();
//        reader = new ReadTXT();
//        writer = new WriteTXT();
        System.out.println("Start");
        
        PC.injectReader(reader);
        PC.injectWriter(writer);
        
        
        CommandConverter CC = new CommandConverter();
        DomainContact DC = DomainContact.getInstance();
        CC.injectDomainContact(DC);
//        TextInputer TI = new TextInputer(CC, DC);
      //  DC.injectVisualController();
//        TI.start();
        sp.startApplication(args);
    }
}
