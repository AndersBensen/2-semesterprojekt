/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import Presentation.CommandConverter;
import javafx.stage.Stage;

/**
 *
 * @author Peter
 */
public interface IInjectableController {
    
    public void injectStage(Stage stage);
    
    public void injectDomainContact(IDomainContact IDC);
    
    public void injectCommandConverter(CommandConverter commandConverter);
    
}
