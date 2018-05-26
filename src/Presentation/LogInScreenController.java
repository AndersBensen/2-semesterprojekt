package Presentation;

import Acquaintance.IDomainContact;
import Acquaintance.IInjectableController;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LogInScreenController implements Initializable, IInjectableController {

    private IDomainContact IDC;
    private CommandConverter CC;
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

    }

    /**
     * Overrided method from IInjectableController.
     * Injects a stage into this controller
     * @param stage 
     */
    @Override
    public void injectStage(Stage stage) {
        this.stage = stage;
    }
    
    /**
     * Overrided method from IInjectableController.
     * Injects a reference of the interface for DomainContact
     * @param IDC 
     */

    @Override
    public void injectDomainContact(IDomainContact IDC)
    {
        this.IDC = IDC;
    }
    
    /**
     * Overrided method from IInjectableController.
     * Injects a reference to CommandConverter
     * @param commandConverter 
     */

    @Override
    public void injectCommandConverter(CommandConverter commandConverter) {
        this.CC = commandConverter;
    }

    @FXML
    private void handleLogIn(ActionEvent event) {
        changeScene();
    }

    @FXML
    private void HandlePW(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            changeScene();
        }
    }
    
    /**
     * This method changes to the system stage, if username and password is
     * valid. If valid, the controller associated with this root injects
     * all the necessary references for CommandConverter, IDomainContact and 
     * stage.
     */
    
    private void changeScene ()
    {
        if (IDC.login(username.getText(), password.getText())) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                Parent root = loader.load();
                
                root.addEventFilter(KeyEvent.KEY_PRESSED, event ->
                {
                    IDC.resetTimer();
                });

                root.addEventFilter(MouseEvent.MOUSE_MOVED, event ->
                {
                    IDC.resetTimer();
                });
                
                IInjectableController controller = loader.getController();
                controller.injectCommandConverter(CC);
                controller.injectDomainContact(IDC);
                controller.injectStage(stage);
                
                Scene newScene = new Scene(root);
                
                stage.setScene(newScene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LogInScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            username.clear();
            username.setPromptText("Forkerte oplysninger");
            password.clear();
        }
    }

}
