package Presentation;

import Acquaintance.ICase;
import Acquaintance.ICaseObject;
import Acquaintance.IDomainContact;
import Acquaintance.IEmployee;
import Acquaintance.IInjectableController;
import Acquaintance.IPerson;
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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable, IVisualController, IInjectableController {

    private IDomainContact IDC;
    private CommandConverter CC;
    private Stage stage;
    private double xOffset;
    private double yOffset;
    private ICaseObject c1 = null;
    private List<ICaseObject> icb;
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
    @FXML
    private JFXTextField CPR;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField birthday;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField gender;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField caseRequestID;
    @FXML
    private TextArea beskrivelse;
    private Label opretteAf;
    @FXML
    private JFXButton gåTil;
    @FXML
    private Label oprettetAf;
    @FXML
    private JFXButton opretSag;
    @FXML
    private JFXButton redigerSag;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DomainContact.getInstance().injectVisualController(this);
        beskrivelse.setVisible(false);
        oprettetAf.setVisible(false);
        gåTil.setVisible(false);
        redigerSag.setVisible(false);

        disableOpretFields();
        ScrollTest.setContent(vboxStart);
        clearHenvendelseFields();
        clearSagFields();

        if (DomainContact.getInstance().getCurrentUser() instanceof SocialWorker) {
            velkommenText.setText(DomainContact.getInstance().getCurrentUser().getUserName());
            adgangsPosition.setText("\n\nMed adgang som: Sagsbehandler");
            /*
            logAf.setLayoutX(OA.getLayoutX());
            logAf.setLayoutY(OA.getLayoutY());
             */
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
        String msc = "false";
        if (klarHenvendelseJa.isSelected()) {
            msc = "true";
        }
        String hbdso = "";
        if (støtteTIlPraktiskOpgave.isSelected()) {
            hbdso += "Støtte til praktiske opgaver i hjemmet#";
        }
        if (støtteTilIndkøb.isSelected()) {
            hbdso += "Støtte til til indkøb og kost#";
        }
        if (støtteTIlPersonligPleje.isSelected()) {
            hbdso += "Støtte til personlig pleje#";
        }
        if (!støtteTilAndet.getText().equals("")) {
            hbdso += støtteTilAndet.getText() + "#";
        }
        if (!hbdso.isEmpty()) {
            hbdso = hbdso.substring(0, hbdso.length() - 1);
        }
        String indforstået = "false";
        if (indforståetJa.isSelected()) {
            indforstået = "true";
        }
        CC.performCommand("caserequest", CPR.getText(), name.getText(), gender.getText(), birthday.getText(), address.getText(), phone.getText(), email.getText(), videreForløbTarea.getText(), msc,
                hbdso, angivTilbud.getText(), henvendelsesPerson.getText(), indforstået);

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
                    opretAnsat.setText("Slet Ansat");

                } else if (opretToggle.getSelectedToggle() == sekretærRadio) {
                    opretAnsat.setText("Opret Ansat");
                    enableOpretAnsat();

                } else if (opretToggle.getSelectedToggle() == sagsbehandlerRadio) {
                    enableOpretAnsat();
                    opretAnsat.setText("Opret Ansat");
                } else {
                    enableOpretAnsat();
                    opretAnsat.setText("Opret Ansat");
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
        dropDown.getItems().removeAll(dropDown.getItems());
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (!ScrollTest.getContent().equals(vboxSøg)) {
                ScrollTest.setContent(vboxSøg);
            }

            this.icb = DomainContact.getInstance().getCaseObject(søgSide.getText()); // returnerer cases og caserequests hvis sagsbehandler, caserequests hvis sekretær 
            for (ICaseObject c : icb) {
                dropDown.getItems().add(c.getType() + ":  " + c.getDateCreated() + ": " + c.getDesc());
                dropDown.setValue(c.getType() + " " + c.getDateCreated() + " " + c.getDesc());
            }
            ScrollTest.setVvalue(xOffset);
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
        logout();
    }

    @Override
    public void logout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("logInScreen.fxml"));
            Parent root = loader.load();
            
            IDC.logout();
            
            IInjectableController controller = loader.getController();
            controller.injectStage(stage);
            controller.injectDomainContact(IDC);
            controller.injectCommandConverter(CC);
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alert()
    {
        ButtonType OKBtn = new ButtonType("OK");
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                Alert alertMenu = new Alert(Alert.AlertType.WARNING);
                alertMenu.setTitle("Advarsel - Logout!");
                alertMenu.setHeaderText("Du bliver logget ud i løbet af 1 minut");
                alertMenu.getButtonTypes().setAll(OKBtn);
                
                alertMenu.getDialogPane().setPrefSize(340, 80);
                
                Optional<ButtonType> result = alertMenu.showAndWait();
                
                if (result.get() == OKBtn)
                    IDC.resetTimer();
            }
        });
        
        
    }
    
    

    @FXML
    private void HandleCPR(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {

            IPerson p = DomainContact.getInstance().getPerson(CPR.getText());
            if (CPR.getText().trim().equals(p.getCpr().trim())) {
                name.setText(p.getName());
                gender.setText(Character.toString(p.getGender()));
                birthday.setText(p.getBirthDate());
                address.setText(p.getAddress());
            } else {
                System.out.println("intet");
            }
        }
    }

    @FXML
    private void HandleOSButton(ActionEvent event) {
        String personalHelper = "";
        if (værgeMedMere.isSelected()) {
            personalHelper += "Værgemål med frataget retslig handleevne#";
        }
        if (samværgemål.isSelected()) {
            personalHelper += "Samværgemål#";
        }
        if (!(værgeInfo.getText().equals(""))) {
            personalHelper += værgeInfo.getText() + "#";
        }

        String PHPOA = "";
        if (bisidder.isSelected()) {
            PHPOA += "Bisidder#";
        }
        if (partsrepræsentant.isSelected()) {
            PHPOA += "Partsrepræsentant#";
        }
        if (fuldmagtMedMere.isSelected()) {
            if (!fuldmagtTekst.getText().equals("")) {
                PHPOA += fuldmagtTekst.getText() + "#";
            }
        }
        if (!PHPOA.isEmpty()) {
            PHPOA = PHPOA.substring(0, PHPOA.length() - 1);
        }

        String electronic = "false";
        if (indforståetElektroniskJa.isSelected()) {
            electronic = "true";
        }

        String consent = "false";
        if (jaSamtykke_sag.isSelected()) {
            consent = "true";
        }

        String consentType = "";
        if (mundtligSamtykke.isSelected()) {
            consentType += "mundtligSamtykke";
        } else if (skriftligSamtykke.isSelected()) {
            consentType += "skriftligSamtykke";
        }

        String collectCitizenInfo = "";
        if (checkEgenLæge.isSelected()) {
            collectCitizenInfo += (char) 945 + AEL.getText() + "#";
        }
        if (checkSpecialLæge.isSelected()) {
            collectCitizenInfo += (char) 946 + ASL.getText() + "#";
        }
        if (checkHospital.isSelected()) {
            collectCitizenInfo += (char) 947 + AH.getText() + "#";
        }
        if (checkAkasse.isSelected()) {
            collectCitizenInfo += (char) 948 + AAK.getText() + "#";
        }
        if (checkTilbud.isSelected()) {
            collectCitizenInfo += (char) 949 + AT.getText() + "#";
        }
        if (checkArbejdsgiver.isSelected()) {
            collectCitizenInfo += (char) 950 + AA.getText() + "#";
        }
        if (checkOPkomune.isSelected()) {
            collectCitizenInfo += (char) 951 + AK.getText() + "#";
        }
        if (checkAndre.isSelected()) {
            collectCitizenInfo += (char) 952 + Andre.getText() + "#";
        }

        String communeInfo = "";
        if (checkEgenKomune.isSelected()) {
            communeInfo += EK.getText() + "#";
        }
        if (checkHandleKomune.isSelected()) {
            communeInfo += HK.getText() + "#";
        }

        CC.performCommand("case", caseRequestID.getText(), videreForløbAftale.getText(), værgemål.getText(), personalHelper, PHPOA, rettighederMedMere.getText(), electronic, consent, consentType, collectCitizenInfo, BorgerInddragelse.getText(), communeInfo, "open");

    }

    @FXML
    private void HandleopretAnsat(ActionEvent event) {
        int i = 0;
        if (sagsbehandlerRadio.isSelected()) {
            i = 2;
            CC.performCommand("addemployee", opretCPR.getText(), opretNavn.getText(), opretKøn.getText(), opretFødselsdag.getText(), opretAdresse.getText(), opretTelefon.getText(), opretEmail.getText(), opretBrugernavn.getText(), opretAdgangskode.getText(), Integer.toString(i));

        } else if (sekretærRadio.isSelected()) {
            i = 1;
            CC.performCommand("addemployee", opretCPR.getText(), opretNavn.getText(), opretKøn.getText(), opretFødselsdag.getText(), opretAdresse.getText(), opretTelefon.getText(), opretEmail.getText(), opretBrugernavn.getText(), opretAdgangskode.getText(), Integer.toString(i));

        } else if (adminRadio.isSelected()) {
            i = 3;
            CC.performCommand("addemployee", opretCPR.getText(), opretNavn.getText(), opretKøn.getText(), opretFødselsdag.getText(), opretAdresse.getText(), opretTelefon.getText(), opretEmail.getText(), opretBrugernavn.getText(), opretAdgangskode.getText(), Integer.toString(i));

        } else if (sletAnsatRadio.isSelected()) {
            if (Integer.parseInt(deleteEmployeeID.getText()) != DomainContact.getInstance().getCurrentUser().getId()) {
                CC.performCommand("deleteemployee", deleteEmployeeID.getText());
            } else {
                deleteEmployeeID.setText("Kan ikke slette dig selv");
                opretNavn.setVisible(false);
                opretAdresse.setVisible(false);
                opretBrugernavn.setVisible(false);
            }

            opretNavn.clear();
            opretAdresse.clear();
            opretBrugernavn.clear();

        }
    }

    @FXML
    private void HandleopretCPR(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {

            IPerson p = DomainContact.getInstance().getPerson(opretCPR.getText());
            if (opretCPR.getText().trim().equals(p.getCpr().trim())) {
                opretNavn.setText(p.getName());
                opretKøn.setText(Character.toString(p.getGender()));
                opretFødselsdag.setText(p.getBirthDate());
                opretAdresse.setText(p.getAddress());
            } else {
                System.out.println("intet");
            }

        }
    }

    @FXML
    private void HandleGåTil(ActionEvent event) {
        ICase c = DomainContact.getInstance().editCase(c1.getID());
        if (c1.getType().equals("CaseRequest")) {
            caseRequestID.setText(Integer.toString(c1.getID()));

            beskrivelse.setVisible(false);
            oprettetAf.setVisible(false);
            gåTil.setVisible(false);
            ScrollTest.setContent(VBox2);
        } else if (c1.getType().equals("Case")) {
            videreForløbAftale.setText(c.getNextAppointment());
            redigerSag.setVisible(true);
            opretSag.setVisible(false);
            beskrivelse.setVisible(false);
            oprettetAf.setVisible(false);
            gåTil.setVisible(false);
            ScrollTest.setContent(VBox2);

            boolean bol = false;
            if (c.getGuardianship().equalsIgnoreCase("værgemål")) {
                bol = true;
            }

            boolean samværgemål1 = false;
            boolean værgemedmere = false;
            String andetString = c.getPersonalHelper();
            if (andetString.contains("Værgemål med frataget retslig handleevne")) {
                værgemedmere = true;
                andetString = andetString.substring(41, andetString.length());
            }
            if (andetString.contains("Samværgemål")) {
                samværgemål1 = true;
                andetString = andetString.substring(12, andetString.length());
            }
            if (!andetString.isEmpty()) {
                andetString = andetString.substring(0, andetString.length() - 1);
                andetString.trim();
            }
            værgeInfo.setText(andetString);

            værgemål.setSelected(bol);
            værgeMedMere.setSelected(værgemedmere);
            this.samværgemål.setSelected(samværgemål1);

            String PHPOAReturnString = c.getPersonalHelperPowerOfAttorney();
            boolean bi = false;
            boolean pr = false;
            if (c.getPersonalHelperPowerOfAttorney().contains("Bisidder")) {
                bi = true;
                this.bisidder.setSelected(bi);
                PHPOAReturnString = PHPOAReturnString.substring(9, PHPOAReturnString.length());
            } else if (c.getPersonalHelperPowerOfAttorney().contains("Partsrepræsentant")) {
                pr = true;
                this.partsrepræsentant.setSelected(pr);
                PHPOAReturnString = PHPOAReturnString.substring(18, PHPOAReturnString.length());
            }
            if (!PHPOAReturnString.isEmpty()) {
                PHPOAReturnString = PHPOAReturnString.substring(0, PHPOAReturnString.length() - 1);
            }
            PHPOAReturnString.trim();
            if (!PHPOAReturnString.isEmpty()) {
                fuldmagtMedMere.setSelected(true);
                fuldmagtTekst.setDisable(false);
            }
            fuldmagtTekst.setText(PHPOAReturnString);

            rettighederMedMere.setText(c.getCitizenRights());

            if (c.isCitizenInformedElectronic()) {
                indforståetElektroniskJa.setSelected(true);
            } else {
                indforståetElektroniskNej.setSelected(true);
            }
            if (c.hasConsent()) {
                jaSamtykke_sag.setSelected(true);
            } else {
                nejSamtykke_sag.setSelected(true);
            }
            if (c.getConsentType().equals("mundtligSamtykke")) {
                mundtligSamtykke.setSelected(true);
                mundtligSamtykke.setDisable(false);
            } else if (c.getConsentType().equals("skriftligSamtykke")) {
                skriftligSamtykke.setSelected(true);
                skriftligSamtykke.setDisable(false);
            }
            String[] citizenInfo = c.getCollectCitizenInfo();
            for (String s : citizenInfo) {
                if (s.contains("" + (char) 945)) {
                    checkEgenLæge.setSelected(true);
                    AEL.setText(s.substring(1, s.length()));
                    AEL.setDisable(false);
                } else if (s.contains("" + (char) 946)) {
                    checkSpecialLæge.setSelected(true);
                    ASL.setText(s.substring(1, s.length()));
                    ASL.setDisable(false);
                } else if (s.contains("" + (char) 947)) {
                    checkHospital.setSelected(true);
                    AH.setText(s.substring(1, s.length()));
                    AH.setDisable(false);
                } else if (s.contains("" + (char) 948)) {
                    checkAkasse.setSelected(true);
                    AAK.setText(s.substring(1, s.length()));
                    AAK.setDisable(false);
                } else if (s.contains("" + (char) 949)) {
                    checkTilbud.setSelected(true);
                    AT.setText(s.substring(1, s.length()));
                    AT.setDisable(false);
                } else if (s.contains("" + (char) 950)) {
                    checkArbejdsgiver.setSelected(true);
                    AA.setText(s.substring(1, s.length()));
                    AA.setDisable(false);
                } else if (s.contains("" + (char) 951)) {
                    checkOPkomune.setSelected(true);
                    AK.setText(s.substring(1, s.length()));
                    AK.setDisable(false);
                } else if (s.contains("" + (char) 952)) {
                    checkAndre.setSelected(true);
                    Andre.setText(s.substring(1, s.length()));
                    Andre.setDisable(false);
                }

            }

            BorgerInddragelse.setText(c.getSpecialCircumstances());
            String DifferentCommuneStatus = c.getDifferentCommune();
            int communeIndex = 0;
            int communeLengthIndex = 0;
            int firstWordLength = 0;
            int secondWordLength = 0;
            int lastWordLength = 0;
            for (char communeChar : DifferentCommuneStatus.toCharArray()) {
                communeLengthIndex++;

                if (communeChar == '#') {
                    communeIndex++;
                } else if (communeIndex == 0) {
                    firstWordLength++;
                } else if (communeIndex >= 1) {
                    secondWordLength++;
                }
            }

            String communeFinalString = c.getDifferentCommune();

            if (communeIndex > 0) {
                checkEgenKomune.setSelected(true);
                EK.setText(communeFinalString.substring(0, firstWordLength));
                EK.setDisable(false);
            }

            if (communeIndex > 1) {
                checkHandleKomune.setSelected(true);
                HK.setText(communeFinalString.substring(firstWordLength + 1, firstWordLength + secondWordLength + 1));
                HK.setDisable(false);
            }

            caseRequestID.setDisable(true);
            handleVærgemål(event);
        }
    }

    @FXML
    private void handDropDown(MouseEvent event) {
        beskrivelse.setVisible(true);
        oprettetAf.setVisible(true);
        gåTil.setVisible(true);
        dropDown.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                int i = 0;
                if ((int) number2 >= 0) {
                    if (i == 0) {
                        c1 = icb.get(((Integer) number2));

                        beskrivelse.setText(icb.get(((Integer) number2)).getDesc());
                        oprettetAf.setText("MedarbejderID: " + Integer.toString(icb.get(((Integer) number2)).getEmployeeID()));
                        i++;
                    }
                }

            }
        });
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
    private void HandleDeleteEmployee(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {

            IEmployee e = DomainContact.getInstance().getEmployee(Integer.parseInt(deleteEmployeeID.getText()));
            if (Integer.parseInt(deleteEmployeeID.getText().trim()) == e.getId()) {
                opretNavn.setVisible(true);
                opretAdresse.setVisible(true);
                opretBrugernavn.setVisible(true);
                opretNavn.setText(e.getName());
                opretAdresse.setText(e.getAddress());
                opretBrugernavn.setText(e.getUserName());
            } else {
                System.out.println("intet");
            }
        }
    }

    @FXML
    private void HandleRedigerSagButton(ActionEvent event) {
        ICase ic = DomainContact.getInstance().editCase(c1.getID());
        redigerSag.setVisible(true);
        String personalHelper = "";
        if (værgeMedMere.isSelected()) {
            personalHelper += "Værgemål med frataget retslig handleevne#";
        }
        if (samværgemål.isSelected()) {
            personalHelper += "Samværgemål#";
        }
        if (!(værgeInfo.getText().equals(""))) {
            personalHelper += værgeInfo.getText() + "#";
        }

        String PHPOA = "";
        if (bisidder.isSelected()) {
            PHPOA += "Bisidder#";
        }
        if (partsrepræsentant.isSelected()) {
            PHPOA += "Partsrepræsentant#";
        }
        if (fuldmagtMedMere.isSelected()) {
            if (!fuldmagtTekst.getText().equals("")) {
                PHPOA += fuldmagtTekst.getText() + "#";
            }
        }
        if (!PHPOA.isEmpty()) {
            PHPOA = PHPOA.substring(0, PHPOA.length() - 1);
        }

        String electronic = "false";
        if (indforståetElektroniskJa.isSelected()) {
            electronic = "true";
        }

        String consent = "false";
        if (jaSamtykke_sag.isSelected()) {
            consent = "true";
        }

        String consentType = "";
        if (mundtligSamtykke.isSelected()) {
            consentType += "mundtligSamtykke";
        } else if (skriftligSamtykke.isSelected()) {
            consentType += "skriftligSamtykke";
        }

        String collectCitizenInfo = "";
        if (checkEgenLæge.isSelected()) {
            collectCitizenInfo += (char) 945 + AEL.getText() + "#";
        }
        if (checkSpecialLæge.isSelected()) {
            collectCitizenInfo += (char) 946 + ASL.getText() + "#";
        }
        if (checkHospital.isSelected()) {
            collectCitizenInfo += (char) 947 + AH.getText() + "#";
        }
        if (checkAkasse.isSelected()) {
            collectCitizenInfo += (char) 948 + AAK.getText() + "#";
        }
        if (checkTilbud.isSelected()) {
            collectCitizenInfo += (char) 949 + AT.getText() + "#";
        }
        if (checkArbejdsgiver.isSelected()) {
            collectCitizenInfo += (char) 950 + AA.getText() + "#";
        }
        if (checkOPkomune.isSelected()) {
            collectCitizenInfo += (char) 951 + AK.getText() + "#";
        }
        if (checkAndre.isSelected()) {
            collectCitizenInfo += (char) 952 + Andre.getText() + "#";
        }

        String communeInfo = "";
        if (checkEgenKomune.isSelected()) {
            communeInfo += EK.getText() + "#";
        }
        if (checkHandleKomune.isSelected()) {
            communeInfo += HK.getText() + "#";
        }
        CC.performCommand("editcase", Integer.toString(ic.getID()), Integer.toString(ic.getEmployeeID()), Integer.toString(ic.getCaseRequest().getID()), videreForløbAftale.getText(), værgemål.getText(), personalHelper, PHPOA, rettighederMedMere.getText(), electronic, consent, consentType, collectCitizenInfo, BorgerInddragelse.getText(), communeInfo, "open", Long.toString(ic.getDateCreated().getTime()));
    }

}
