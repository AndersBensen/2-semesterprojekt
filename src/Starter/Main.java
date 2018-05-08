/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Domain.DomainContact;
import Acquaintance.IDomainContact;
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
    }

}
