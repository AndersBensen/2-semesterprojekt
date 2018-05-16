package Starter;

import Acquaintance.IReader;
import Acquaintance.IWriter;
import Domain.DomainContact;
import Domain.PersistanceContact;
import Persistence.ReadDB;
import Persistence.ReadTXT;
import Persistence.WriteDB;
import Persistence.WriteTXT;
import Presentation.CommandConverter;
import Presentation.TextInputer;

public class Main {

    public static void main(String[] args) {
        
        PersistanceContact PC = PersistanceContact.getInstance();

        IReader reader = new ReadDB();
        IWriter writer = new WriteDB();
//        reader = new ReadTXT();
//        writer = new WriteTXT();
        
        
        PC.injectReader(reader);
        PC.injectWriter(writer);

        CommandConverter CC = new CommandConverter();
        DomainContact DC = DomainContact.getInstance();
        CC.injectDomainContact(DC);
        TextInputer TI = new TextInputer(CC, DC);
        DC.injectVisualController(TI);
        TI.start();
    }
}
