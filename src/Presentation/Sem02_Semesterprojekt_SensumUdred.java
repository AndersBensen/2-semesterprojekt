package Presentation;

import Acquaintance.IDomainContact;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Sem02_Semesterprojekt_SensumUdred extends Application {

    
    private static IDomainContact IDC;
    
    public void injectDomain(IDomainContact _DC){
        IDC = _DC;
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("logInScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        
        stage.getIcons().add(
        new Image(
        Sem02_Semesterprojekt_SensumUdred.class.getResourceAsStream("appLogo.png")));
        stage.setResizable(false);
        stage.setTitle("EG Team Online - Sensum Udred");
        stage.setScene(scene);
        stage.setScene(scene);
        stage.sizeToScene();
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
    public static IDomainContact getDomainContact(){
        return IDC;
    }
    
    public void startApplication(String[] args) {
        launch(args);
    }

}
