package Starter;

import Acquaintance.IReader;
import Acquaintance.IWriter;
import Domain.DomainContact;
import Domain.PersistanceContact;
import Persistence.ReadDB;
import Persistence.WriteDB;
import Presentation.CommandConverter;
import Presentation.Sem02_Semesterprojekt_SensumUdred;

public class Main {

    public static void main(String[] args) {

        PersistanceContact PC = PersistanceContact.getInstance();

        IReader reader = new ReadDB();
        IWriter writer = new WriteDB();

        Sem02_Semesterprojekt_SensumUdred sp = new Sem02_Semesterprojekt_SensumUdred();

        PC.injectReader(reader);
        PC.injectWriter(writer);

        CommandConverter CC = new CommandConverter();
        DomainContact DC = DomainContact.getInstance();
        CC.injectDomainContact(DC);
        sp.injectDomain(DC);
        sp.injectCommandConverter(CC);

        sp.startApplication(args);
    }
}
