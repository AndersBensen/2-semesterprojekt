package Presentation;

import Acquaintance.IDomainContact;
import Acquaintance.IInjectableController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Sem02_Semesterprojekt_SensumUdred extends Application {

    
    private static IDomainContact IDC;
    private static CommandConverter CC;
    
    public void injectDomain(IDomainContact _DC){
        IDC = _DC;
    }
    
    public void injectCommandConverter(CommandConverter CC){
        this.CC = CC;
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("logInScreen.fxml"));
         Parent root = loader.load();
        
        Scene scene = new Scene(root);
        IInjectableController controller = loader.getController();
        controller.injectStage(stage);
        
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
    
    public static CommandConverter getCommandConverter(){
        return CC;
    } 
    
    public void startApplication(String[] args) {
        launch(args);
    }

}
