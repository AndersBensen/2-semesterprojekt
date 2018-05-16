/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquaintance.IVisualController;
import Domain.Admin;
import Domain.DomainContact;
import Domain.Secretary;
import Domain.SocialWorker;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Peter
 */
public class FXMLDocumentController implements Initializable, IVisualController {

    private Stage stage;
    private double xOffset;
    private double yOffset;
    @FXML
    private VBox testVbox;
    @FXML
    private ScrollPane ScrollTest;
    @FXML
    private JFXButton OH;
    @FXML
    private JFXButton OS;
    @FXML
    private JFXButton OA;
    @FXML
    private VBox VBox2;
    @FXML
    private TextArea videreForløbTarea;
    @FXML
    private JFXCheckBox klarHenvendelseJa;
    @FXML
    private JFXCheckBox klarHenvendelseNej;
    @FXML
    private JFXCheckBox støtteTIlPraktiskOpgave;
    @FXML
    private JFXCheckBox støtteTIlPersonligPleje;
    @FXML
    private JFXTextField støtteTilAndet;
    @FXML
    private JFXTextField angivTilbud;
    @FXML
    private JFXTextField henvendelsesPerson;
    @FXML
    private JFXCheckBox indforståetJa;
    @FXML
    private JFXCheckBox indforståetNej;
    @FXML
    private JFXButton opretHenvendelseButton;
    @FXML
    private VBox VBoxAnsat;
    @FXML
    private ToggleGroup opretToggle;
    @FXML
    private JFXRadioButton sagsbehandlerRadio;
    @FXML
    private JFXRadioButton sletAnsatRadio;
    @FXML
    private JFXRadioButton adminRadio;
    @FXML
    private JFXRadioButton sekretærRadio;
    @FXML
    private JFXTextField deleteEmployeeID;
    @FXML
    private JFXTextField opretCPR;
    @FXML
    private JFXTextField opretNavn;
    @FXML
    private JFXTextField opretKøn;
    @FXML
    private JFXTextField opretFødselsdag;
    @FXML
    private JFXTextField opretAdresse;
    @FXML
    private JFXTextField opretTelefon;
    @FXML
    private JFXTextField opretEmail;
    @FXML
    private JFXTextField opretBrugernavn;
    @FXML
    private JFXTextField opretAdgangskode;
    @FXML
    private JFXButton opretAnsat;
    @FXML
    private JFXCheckBox støtteTilIndkøb;
    @FXML
    private VBox vboxStart;
    @FXML
    private JFXTextField værgeInfo;
    @FXML
    private TextArea videreForløbAftale;
    @FXML
    private JFXCheckBox værgemål;
    @FXML
    private JFXCheckBox samværgemål;
    @FXML
    private Label værgeLabel;
    @FXML
    private JFXCheckBox værgeMedMere;
    @FXML
    private JFXCheckBox bisidder;
    @FXML
    private Label repræsentationLabel;
    @FXML
    private JFXCheckBox fuldmagtMedMere;
    @FXML
    private JFXCheckBox partsrepræsentant;
    @FXML
    private JFXTextField fuldmagtTekst;
    @FXML
    private JFXTextField rettighederMedMere;
    @FXML
    private JFXCheckBox indforståetElektroniskJa;
    @FXML
    private JFXCheckBox indforståetElektroniskNej;
    @FXML
    private JFXCheckBox jaSamtykke_sag;
    @FXML
    private JFXCheckBox nejSamtykke_sag;
    @FXML
    private JFXCheckBox mundtligSamtykke;
    @FXML
    private JFXCheckBox skriftligSamtykke;
    @FXML
    private JFXCheckBox checkEgenLæge;
    @FXML
    private JFXCheckBox checkSpecialLæge;
    @FXML
    private JFXCheckBox checkHospital;
    @FXML
    private JFXCheckBox checkAkasse;
    @FXML
    private JFXCheckBox checkTilbud;
    @FXML
    private JFXCheckBox checkArbejdsgiver;
    @FXML
    private JFXCheckBox checkOPkomune;
    @FXML
    private JFXCheckBox checkAndre;
    @FXML
    private JFXTextField AEL;
    @FXML
    private JFXTextField ASL;
    @FXML
    private JFXTextField AH;
    @FXML
    private JFXTextField AAK;
    @FXML
    private JFXTextField AT;
    @FXML
    private JFXTextField AA;
    @FXML
    private JFXTextField AK;
    @FXML
    private JFXTextField Andre;
    @FXML
    private TextArea BorgerInddragelse;
    @FXML
    private JFXCheckBox checkEgenKomune;
    @FXML
    private JFXCheckBox checkHandleKomune;
    @FXML
    private JFXTextField EK;
    @FXML
    private JFXTextField HK;
    @FXML
    private ChoiceBox<String> dropDown;
    private JFXTextField søgInput;
    @FXML
    private JFXTextField søgSide;
    @FXML
    private VBox vboxSøg;
    @FXML
    private VBox vbox;
    @FXML
    private Label velkommenText;
    @FXML
    private JFXButton logAf;
    @FXML
    private Label adgangsPosition;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DomainContact.getInstance().injectVisualController(this);

        disableOpretFields();
        ScrollTest.setContent(vboxStart);
        clearHenvendelseFields();
        clearSagFields();

        if (DomainContact.getInstance().getCurrentUser() instanceof SocialWorker) {
            velkommenText.setText(DomainContact.getInstance().getCurrentUser().getUserName());
            adgangsPosition.setText("\n\nMed adgang som: Sagsbehandler");
            OA.setVisible(false);
        } else if (DomainContact.getInstance().getCurrentUser() instanceof Secretary) {
            velkommenText.setText(DomainContact.getInstance().getCurrentUser().getUserName());
            adgangsPosition.setText("\n\nMed adgang som: Sekretær");
            OA.setVisible(false);
            OS.setVisible(false);
        } else if (DomainContact.getInstance().getCurrentUser() instanceof Admin) {
            velkommenText.setText(DomainContact.getInstance().getCurrentUser().getUserName());
            adgangsPosition.setText("\n\nMed adgang som: Administrator");
            OH.setVisible(false);
            OS.setVisible(false);
            søgSide.setVisible(false);
        }

    }

    @FXML
    private void HandleOH(ActionEvent event) {      //checkbox i OH

        ScrollTest.setContent(testVbox);

//        klarHenvendelseJa.setSelected(false);
//        klarHenvendelseNej.setSelected(false);
//        støtteTIlPersonligPleje.setSelected(false);
//        støtteTIlPraktiskOpgave.setSelected(false);
//        støtteTilAndet.clear();
//        støtteTilIndkøb.setDisable(true);
//        støtteTIlPraktiskOpgave.setDisable(true);
//        støtteTIlPersonligPleje.setDisable(true);
//        støtteTilAndet.setDisable(true);
    }

    @FXML
    private void HandleklarHenvendelseJa(ActionEvent event) {       //checkbox i OH
        if (klarHenvendelseJa.isSelected()) {
            støtteTilIndkøb.setDisable(false);
            støtteTIlPraktiskOpgave.setDisable(false);
            støtteTIlPersonligPleje.setDisable(false);
            støtteTilAndet.setDisable(false);
            klarHenvendelseNej.setSelected(false);

        } else if (!klarHenvendelseJa.isSelected()) {
            støtteTilIndkøb.setDisable(true);
            støtteTIlPraktiskOpgave.setDisable(true);
            støtteTIlPersonligPleje.setDisable(true);
            støtteTilAndet.setDisable(true);

            støtteTilIndkøb.setSelected(false);
            støtteTIlPraktiskOpgave.setSelected(false);
            støtteTIlPersonligPleje.setSelected(false);
            støtteTilAndet.clear();

        }
    }

    @FXML
    private void handleKlarHenvendelseNej(ActionEvent event) {
        støtteTilIndkøb.setDisable(true);
        støtteTIlPraktiskOpgave.setDisable(true);
        støtteTIlPersonligPleje.setDisable(true);
        støtteTilAndet.setDisable(true);
        klarHenvendelseJa.setSelected(false);
        støtteTilIndkøb.setSelected(false);
        støtteTIlPraktiskOpgave.setSelected(false);
        støtteTIlPersonligPleje.setSelected(false);
        støtteTilAndet.clear();
    }

    @FXML
    private void HandleOS(ActionEvent event) {
        ScrollTest.setContent(VBox2);
    }

    @FXML
    private void HandleOpretHenvendelse(ActionEvent event) {        //Knappen

        String s = "";
        s += videreForløbTarea.getText() + ";";
        if (klarHenvendelseJa.isSelected()) {
            s += "true";
        } else {
            s += "false";
        }
        System.out.println("vi fik: " + s);
    }

    @FXML
    private void HandleOA(ActionEvent event) {

        clearOpretFields();
        opretToggle.selectToggle(null);
        disableOpretFields();
        ScrollTest.setContent(VBoxAnsat);

        Object source = event.getSource();
        opretToggle.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (opretToggle.getSelectedToggle() == sletAnsatRadio) {
                    disableOpretFields();

                    deleteEmployeeID.setVisible(true);
                    opretAnsat.setVisible(true);

                } else if (opretToggle.getSelectedToggle() == sekretærRadio) {
                    enableOpretAnsat();

                } else if (opretToggle.getSelectedToggle() == sagsbehandlerRadio) {
                    enableOpretAnsat();
                } else {
                    enableOpretAnsat();
                }

            }
        });

    }

    private void disableOpretFields() {
        opretCPR.setVisible(false);
        opretNavn.setVisible(false);
        opretKøn.setVisible(false);
        opretFødselsdag.setVisible(false);
        opretAdresse.setVisible(false);
        opretTelefon.setVisible(false);
        opretEmail.setVisible(false);
        opretBrugernavn.setVisible(false);
        opretAdgangskode.setVisible(false);
        deleteEmployeeID.setVisible(false);
        opretAnsat.setVisible(false);

        //
    }

    private void enableOpretAnsat() {
        opretCPR.setVisible(true);
        opretNavn.setVisible(true);
        opretKøn.setVisible(true);
        opretFødselsdag.setVisible(true);
        opretAdresse.setVisible(true);
        opretTelefon.setVisible(true);
        opretEmail.setVisible(true);
        opretBrugernavn.setVisible(true);
        opretAdgangskode.setVisible(true);
        opretAnsat.setVisible(true);
        deleteEmployeeID.setVisible(false);

    }

    private void clearOpretFields() {
        opretCPR.clear();
        opretNavn.clear();
        opretKøn.clear();
        opretFødselsdag.clear();
        opretAdresse.clear();
        opretTelefon.clear();
        opretEmail.clear();
        opretBrugernavn.clear();
        opretAdgangskode.clear();
        deleteEmployeeID.clear();
    }

    @FXML
    private void handleindforståetJa(ActionEvent event) {
        if (indforståetJa.isSelected()) {
            indforståetNej.setSelected(false);

        }
    }

    @FXML
    private void handleindforståetNej(ActionEvent event) {
        if (indforståetNej.isSelected()) {
            indforståetJa.setSelected(false);
        }
    }

    @FXML
    private void handleVærgemål(ActionEvent event) {

        if (værgemål.isSelected()) {
            værgeMedMere.setDisable(false);
            samværgemål.setDisable(false);
            værgeInfo.setDisable(false);
            bisidder.setDisable(false);
            partsrepræsentant.setDisable(false);
            fuldmagtMedMere.setDisable(false);
            værgeLabel.setDisable(false);
            repræsentationLabel.setDisable(false);
        } else if (!værgemål.isSelected()) {
            værgeMedMere.setDisable(true);
            samværgemål.setDisable(true);
            værgeInfo.setDisable(true);
            bisidder.setDisable(true);
            partsrepræsentant.setDisable(true);
            fuldmagtMedMere.setDisable(true);
            værgeLabel.setDisable(true);
            repræsentationLabel.setDisable(true);

            værgemål.setSelected(false);
            samværgemål.setSelected(false);
            værgeInfo.clear();
            bisidder.setSelected(false);
            partsrepræsentant.setSelected(false);
            fuldmagtMedMere.setSelected(false);
            fuldmagtTekst.clear();
            fuldmagtTekst.setDisable(true);

            værgeMedMere.setSelected(false);
            samværgemål.setSelected(false);
            værgeInfo.clear();
            bisidder.setSelected(false);
            partsrepræsentant.setSelected(false);
            fuldmagtMedMere.setSelected(false);

        }
    }

    @FXML
    private void handleFuldmagt(ActionEvent event) {
        if (fuldmagtMedMere.isSelected()) {
            fuldmagtTekst.setDisable(false);
        } else if (!fuldmagtMedMere.isSelected()) {
            fuldmagtTekst.setDisable(true);
            fuldmagtTekst.clear();
        }
    }

    @FXML
    private void handleIndforståetElektroniskJa(ActionEvent event) {
        if (indforståetElektroniskJa.isSelected()) {
            indforståetElektroniskNej.setSelected(false);

        }
    }

    @FXML
    private void handleIndforståetElektronisknej(ActionEvent event) {
        if (indforståetElektroniskNej.isSelected()) {
            indforståetElektroniskJa.setSelected(false);
        }
    }

    @FXML
    private void handleJaSamtykke_sag(ActionEvent event) {
        if (jaSamtykke_sag.isSelected()) {
            nejSamtykke_sag.setSelected(false);
            mundtligSamtykke.setDisable(false);
            skriftligSamtykke.setDisable(false);

        } else if (!jaSamtykke_sag.isSelected()) {

            mundtligSamtykke.setDisable(true);
            skriftligSamtykke.setDisable(true);
            mundtligSamtykke.setSelected(false);
            skriftligSamtykke.setSelected(false);

        }

    }

    @FXML
    private void handleNejSamtykke_sag(ActionEvent event) {
        if (nejSamtykke_sag.isSelected()) {
            jaSamtykke_sag.setSelected(false);
            mundtligSamtykke.setDisable(true);
            skriftligSamtykke.setDisable(true);

            mundtligSamtykke.setDisable(true);
            skriftligSamtykke.setDisable(true);
            mundtligSamtykke.setSelected(false);
            skriftligSamtykke.setSelected(false);

        }
    }

    @FXML
    private void handleMundtligSamtykke(ActionEvent event) {
        if (mundtligSamtykke.isSelected()) {
            skriftligSamtykke.setSelected(false);
        }

    }

    @FXML
    private void handleSkriftligSamtykke(ActionEvent event) {
        if (skriftligSamtykke.isSelected()) {
            mundtligSamtykke.setSelected(false);
        }

    }

    @FXML
    private void handleEgenLæge(ActionEvent event) {
        if (checkEgenLæge.isSelected()) {
            AEL.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AEL.setDisable(true);
            AEL.clear();
        }
    }

    @FXML
    private void handleSpecialLæge(ActionEvent event) {
        if (checkSpecialLæge.isSelected()) {
            ASL.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            ASL.setDisable(true);
            ASL.clear();
        }
    }

    @FXML
    private void handleHospital(ActionEvent event) {
        if (checkHospital.isSelected()) {
            AH.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AH.setDisable(true);
            AH.clear();
        }
    }

    @FXML
    private void handleAkasse(ActionEvent event) {
        if (checkAkasse.isSelected()) {
            AAK.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AAK.setDisable(true);
            AAK.clear();
        }
    }

    @FXML
    private void handleTilbud(ActionEvent event) {
        if (checkTilbud.isSelected()) {
            AT.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AT.setDisable(true);
            AT.clear();
        }
    }

    @FXML
    private void handleArbejdsgiver(ActionEvent event) {
        if (checkArbejdsgiver.isSelected()) {
            AA.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AA.setDisable(true);
            AA.clear();
        }
    }

    @FXML
    private void handleOPkomune(ActionEvent event) {
        if (checkOPkomune.isSelected()) {
            AK.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AK.setDisable(true);
            AK.clear();
        }
    }

    @FXML
    private void handleAndre(ActionEvent event) {
        if (checkAndre.isSelected()) {
            Andre.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            Andre.setDisable(true);
            Andre.clear();
        }
    }

    @FXML
    private void handleEgenKomune(ActionEvent event) {
        if (checkEgenKomune.isSelected()) {
            EK.setDisable(false);
        } else if (!checkEgenKomune.isSelected()) {
            EK.setDisable(true);
            EK.clear();
        }

    }

    @FXML
    private void handleHandleKomune(ActionEvent event) {
        if (checkHandleKomune.isSelected()) {
            HK.setDisable(false);
        } else if (!checkHandleKomune.isSelected()) {
            HK.setDisable(true);
            HK.clear();
        }
    }

    private void handleSøgSag(ActionEvent event) {

        dropDown.getItems().add(søgInput.getText());
        dropDown.setValue(søgInput.getText());

    }

    @FXML
    private void handleSøg(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            ScrollTest.setContent(vboxSøg);

            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());
            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());
            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());
            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());
            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());
            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());
            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());
            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());
            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());
            dropDown.getItems().add(søgSide.getText());
            dropDown.setValue(søgSide.getText());

            søgSide.clear();

        }
    }

    @FXML
    private void handleCheckBisidder(ActionEvent event) {
        if (bisidder.isSelected()) {
            partsrepræsentant.setSelected(false);
        }
    }

    @FXML
    private void handleCheckPartsRepræsentant(ActionEvent event) {
        if (partsrepræsentant.isSelected()) {
            bisidder.setSelected(false);
        }
    }

    private void clearHenvendelseFields() {
        klarHenvendelseJa.setSelected(false);
        klarHenvendelseNej.setSelected(false);
        støtteTIlPersonligPleje.setSelected(false);
        støtteTIlPraktiskOpgave.setSelected(false);
        støtteTilAndet.clear();

        støtteTilIndkøb.setDisable(true);
        støtteTIlPraktiskOpgave.setDisable(true);
        støtteTIlPersonligPleje.setDisable(true);
        støtteTilAndet.setDisable(true);

    }

    private void clearSagFields() {
        værgemål.setSelected(false);
        værgeMedMere.setSelected(false);
        samværgemål.setSelected(false);
        værgeInfo.clear();
        bisidder.setSelected(false);
        partsrepræsentant.setSelected(false);
        fuldmagtMedMere.setSelected(false);
        fuldmagtTekst.clear();
        mundtligSamtykke.setSelected(false);
        skriftligSamtykke.setSelected(false);

        værgeMedMere.setDisable(true);
        samværgemål.setDisable(true);
        værgeInfo.setDisable(true);
        bisidder.setDisable(true);
        partsrepræsentant.setDisable(true);
        fuldmagtMedMere.setDisable(true);
        fuldmagtTekst.setDisable(true);
        værgeLabel.setDisable(true);
        repræsentationLabel.setDisable(true);

        mundtligSamtykke.setDisable(true);
        skriftligSamtykke.setDisable(true);

        AEL.setDisable(true);
        ASL.setDisable(true);
        AH.setDisable(true);
        AAK.setDisable(true);
        AT.setDisable(true);
        AA.setDisable(true);
        AK.setDisable(true);
        Andre.setDisable(true);

        EK.setDisable(true);
        HK.setDisable(true);
    }

    @FXML
    private void HandleLogOut(ActionEvent event) {
        try {
            Parent nextView = FXMLLoader.load(getClass().getResource("logInScreen.fxml"));
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
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void logout() {
        try {
            Parent nextView = FXMLLoader.load(getClass().getResource("logInScreen.fxml"));
            Scene newScene = new Scene(nextView);
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
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
