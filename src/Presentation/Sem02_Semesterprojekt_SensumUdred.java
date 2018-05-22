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

    public void injectDomain(IDomainContact IDC) {
        this.IDC = IDC;
    }

    public void injectCommandConverter(CommandConverter CC) {
        this.CC = CC;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("logInScreen.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        IInjectableController controller = loader.getController();
        controller.injectStage(stage);
        controller.injectDomainContact(IDC);
        controller.injectCommandConverter(CC);

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

    public void startApplication(String[] args) {
        launch(args);
    }

}
