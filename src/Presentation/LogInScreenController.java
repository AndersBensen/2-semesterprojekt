/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquaintance.IDomainContact;
import Acquaintance.IVisualController;
import Domain.DomainContact;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Peter
 */
public class LogInScreenController implements Initializable, IVisualController{
    private IDomainContact IDC;
    private Stage stage;
    private double xOffset;
    private double yOffset;
    @FXML
    private JFXButton logInButton;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IDC = Sem02_Semesterprojekt_SensumUdred.getDomainContact();
         DomainContact.getInstance().injectVisualController(this);
    }
    

    @FXML
    private void handleLogIn(ActionEvent event) {
        System.out.println(IDC);
      //  System.out.println(username.getText() + " " + password.getText() + " med dc " + DomainContact.getInstance());
      //  if (DomainContact.getInstance().login(username.getText(), password.getText())) {
           
            try {
                Parent nextView = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene newScene = new Scene(nextView);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(newScene);
                stage.show();
                nextView.setOnMousePressed((javafx.scene.input.MouseEvent event1) -> {
                    xOffset = event1.getSceneX();
                    yOffset = event1.getSceneY();
                });
                nextView.setOnMouseDragged((javafx.scene.input.MouseEvent event1) -> {
                    stage.setX(event1.getScreenX() - xOffset);
                    stage.setY(event1.getScreenY() - yOffset);
                });
            } catch (IOException ex) {
                Logger.getLogger(LogInScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
//        else{
//            username.clear();
//            username.setPromptText("Forkerte oplysninger");
//            password.clear();
//        }
//
//    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
