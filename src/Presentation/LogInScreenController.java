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

    @Override
    public void injectStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void injectDomainContact(IDomainContact IDC)
    {
        this.IDC = IDC;
    }

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
    
    private void changeScene ()
    {
        if (IDC.login(username.getText(), password.getText())) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                Parent root = loader.load();
                
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
