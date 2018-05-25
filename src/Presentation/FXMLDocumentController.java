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
        clearSagFields();
        redigerSag.setVisible(false);
        opretSag.setVisible(true);
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
    
    /**
     * When this handler is called, there will be checked for
     * which information is written and selected in the formular.
     * These information will be sended to this classes reference
     * to the commandconverter which handles the communication to the next
     * layer.
     * @param event 
     */

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
        clearHenvendelseFields();
    }

    /**
     * This eventhandler, changes the stage to a new scene which contains
     * vBox stage showing a formular for creating an employee in the system.
     * The nested changed method is used to keep track of which toggleButton
     * is the currently selected.
     * @param event 
     */
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
    

    /**
     * disables the prompt fields  in the stage create employee,
     * makng them uneditable and invisible.Is used to controll which fields
     * should be shown as there are different kinds of employees which can be
     * created.
     */
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
    }
    

    /**
     * enables the prompt fields  in the stage create employee,
     * makng them editable and visible. Is used to controll which fields
     * should be shown as there are different kinds of employees which can be
     * created.
     */
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

    /**
     * clears the prompt fields  in the stage create employee
     */
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
    

    /**
     * This eventhandler assures that only one checkbox can be selceted
     * at a time. 
     * @param event 
     */
    @FXML
    private void handleindforståetJa(ActionEvent event) {
        if (indforståetJa.isSelected()) {
            indforståetNej.setSelected(false);
        }
    }

    /**
     * This eventhandler assures that only one checkbox can be selceted
     * at a time. 
     * @param event 
     */
    @FXML
    private void handleindforståetNej(ActionEvent event) {
        if (indforståetNej.isSelected()) {
            indforståetJa.setSelected(false);
        }
    }

    /**
     * This eventhandler enables all the necessary fields in the formular
     * making them editable. This aciton occurs when the checkbox værgemål is 
     * selected.
     * @param event 
     */
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

    /**
     * This eventhandler checks if the checkbox fuldmagtMedMere is selected.
     * if the checkbox in the formular is selected, the textfield for
     * writing information is enabbled and editable.
     * @param event 
     */
    @FXML
    private void handleFuldmagt(ActionEvent event) {
        if (fuldmagtMedMere.isSelected()) {
            fuldmagtTekst.setDisable(false);
        } else if (!fuldmagtMedMere.isSelected()) {
            fuldmagtTekst.setDisable(true);
            fuldmagtTekst.clear();
        }
    }

    /**
     * This eventhandler assures that only one checkbox can be selceted
     * at a time. 
     * @param event 
     */
    @FXML
    private void handleIndforståetElektroniskJa(ActionEvent event) {
        if (indforståetElektroniskJa.isSelected()) {
            indforståetElektroniskNej.setSelected(false);
        }
    }

    /**
     * This eventhandler assures that only one checkbox can be selceted
     * at a time. 
     * @param event 
     */
    @FXML
    private void handleIndforståetElektronisknej(ActionEvent event) {
        if (indforståetElektroniskNej.isSelected()) {
            indforståetElektroniskJa.setSelected(false);
        }
    }

    /**
     * This eventhandler assures that only one checkbox can be selected at
     * a time. It also assures if the checkbox is selected is 'ja', then 
     * two additional checkboxes, 'mundtlig skriftlig' and 'skriftlig samtykke' 
     * will be enabled and editable. One of these two checkboxes can only be
     * selected at a time.
     * @param event 
     */
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

    /**
     * This eventhandler assures that if the checkbox 'nej' is selected the
     * two additional checkboxes 'mundtlig samtykke' and 'skriftlig samtykke'
     * is diasbled and uneditable.
     * @param event 
     */
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

    /**
     * Assures that only 'mundtligSamtykke' and 'skriftligsamtykke' can be 
     * slected at a time.
     * @param event 
     */
    @FXML
    private void handleMundtligSamtykke(ActionEvent event) {
        if (mundtligSamtykke.isSelected()) {
            skriftligSamtykke.setSelected(false);
        }
    }

    /**
     * Assures that only 'mundtligSamtykke' and 'skriftligsamtykke' can be 
     * selected at a time.
     * @param event 
     */
    @FXML
    private void handleSkriftligSamtykke(ActionEvent event) {
        if (skriftligSamtykke.isSelected()) {
            mundtligSamtykke.setSelected(false);
        }
    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected. In this case if the checkbox
     * 'checkEgenLæge' is selected the textfield 'AEL' will be enabled.
     * @param event 
     */
    @FXML
    private void handleEgenLæge(ActionEvent event) {
        if (checkEgenLæge.isSelected()) {
            AEL.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AEL.setDisable(true);
            AEL.clear();
        }
    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected.
     * @param event 
     */
    @FXML
    private void handleSpecialLæge(ActionEvent event) {
        if (checkSpecialLæge.isSelected()) {
            ASL.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            ASL.setDisable(true);
            ASL.clear();
        }
    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected.
     * @param event 
     */
    @FXML
    private void handleHospital(ActionEvent event) {
        if (checkHospital.isSelected()) {
            AH.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AH.setDisable(true);
            AH.clear();
        }
    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected.
     * @param event 
     */
    @FXML
    private void handleAkasse(ActionEvent event) {
        if (checkAkasse.isSelected()) {
            AAK.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AAK.setDisable(true);
            AAK.clear();
        }
    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected.
     * @param event 
     */
    @FXML
    private void handleTilbud(ActionEvent event) {
        if (checkTilbud.isSelected()) {
            AT.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AT.setDisable(true);
            AT.clear();
        }
    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected.
     * @param event 
     */
    @FXML
    private void handleArbejdsgiver(ActionEvent event) {
        if (checkArbejdsgiver.isSelected()) {
            AA.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AA.setDisable(true);
            AA.clear();
        }
    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected.
     * @param event 
     */
    @FXML
    private void handleOPkomune(ActionEvent event) {
        if (checkOPkomune.isSelected()) {
            AK.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            AK.setDisable(true);
            AK.clear();
        }
    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected.
     * @param event 
     */
    @FXML
    private void handleAndre(ActionEvent event) {
        if (checkAndre.isSelected()) {
            Andre.setDisable(false);
        } else if (!checkEgenLæge.isSelected()) {
            Andre.setDisable(true);
            Andre.clear();
        }
    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected.
     * @param event 
     */
    @FXML
    private void handleEgenKomune(ActionEvent event) {
        if (checkEgenKomune.isSelected()) {
            EK.setDisable(false);
        } else if (!checkEgenKomune.isSelected()) {
            EK.setDisable(true);
            EK.clear();
        }

    }

    /**
     * This handler enables its assoicated textfield making it editable if
     * its assoicated chekbox is selected.
     * @param event 
     */
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

    /**
     * This method handles the searchbare 'søg' when the Enter is pressed. 
     * When pressed, the eventlistener changes the stage to a new scene with 
     * a dropDown menu, showing caserequests and cases. This class has a list 
     * 'icb' which contains objects of ICaseObject. getCaseObject is called with
     * the CPR number entered in the search bar. All the existing cases will
     * then be added to an observable list in the javaFX dropDown menu. 
     * @param event 
     */
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

    /**
     * assures that only one of 'bisidder' and 'partsrepræsentant' checkbox 
     * can be selected at a time.
     * @param event 
     */
    @FXML
    private void handleCheckBisidder(ActionEvent event) {
        if (bisidder.isSelected()) {
            partsrepræsentant.setSelected(false);
        }
    }

    /**
     * assures that only one of 'bisidder' and 'partsrepræsentant' checkbox 
     * can be selected at a time.
     * @param event 
     */
    @FXML
    private void handleCheckPartsRepræsentant(ActionEvent event) {
        if (partsrepræsentant.isSelected()) {
            bisidder.setSelected(false);
        }
    }

    /**
     * clears all the checkboxes and disables them. Is used in initalize()
     */
    private void clearHenvendelseFields() {
        CPR.clear();
        name.clear();
        gender.clear();
        birthday.clear();
        address.clear();
        phone.clear();
        email.clear();
        videreForløbTarea.clear();
        klarHenvendelseJa.setSelected(false);
        klarHenvendelseNej.setSelected(false);
        støtteTIlPersonligPleje.setSelected(false);
        støtteTIlPraktiskOpgave.setSelected(false);
        støtteTilAndet.clear();
        støtteTilIndkøb.setDisable(true);
        støtteTIlPraktiskOpgave.setDisable(true);
        støtteTIlPersonligPleje.setDisable(true);
        støtteTilAndet.setDisable(true);
        angivTilbud.clear();
        henvendelsesPerson.clear();
        indforståetJa.setSelected(false);
        indforståetNej.setSelected(false);
        
    }

     /**
     * clears all the checkboxes and disables them. Is used in initalize()
     */
    private void clearSagFields() {
        værgemål.setSelected(false);
        værgeMedMere.setSelected(false);
        samværgemål.setSelected(false);
        værgeInfo.clear();
        bisidder.setSelected(false);
        partsrepræsentant.setSelected(false);
        fuldmagtMedMere.setSelected(false);
        fuldmagtTekst.clear();
        rettighederMedMere.clear();
        mundtligSamtykke.setSelected(false);
        skriftligSamtykke.setSelected(false);
        checkEgenLæge.setSelected(false);
        AEL.clear();
        AEL.setDisable(true);
        checkSpecialLæge.setSelected(false);
        ASL.clear();
        ASL.setDisable(true);
        checkHospital.setSelected(false);
        AH.clear();
        AH.setDisable(true);
        checkAkasse.setSelected(false);
        AAK.clear();
        AAK.setDisable(true);
        checkTilbud.setSelected(false);
        AT.clear();
        AT.setDisable(true);
        checkArbejdsgiver.setSelected(false);
        AA.clear();
        AA.setDisable(true);
        checkOPkomune.setSelected(false);
        AK.clear();
        AK.setDisable(true);
        checkAndre.setSelected(false);
        Andre.clear();
        Andre.setDisable(true);
        BorgerInddragelse.clear();
        checkEgenKomune.setSelected(false);
        EK.clear();
        EK.setDisable(true);
        checkHandleKomune.setSelected(false);
        HK.clear();
        HK.setDisable(true);
        caseRequestID.clear();
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
        indforståetElektroniskJa.setSelected(false);
        indforståetElektroniskNej.setSelected(false);
        videreForløbAftale.clear();
        jaSamtykke_sag.setSelected(false);
        nejSamtykke_sag.setSelected(false);
    }

    @FXML
    private void HandleLogOut(ActionEvent event) {
        logout();
    }

    /**
     * This method is used for the button with fxid 'HandleLogOut'. 
     * The method loads the parentroot as the 'logInScreen.fxml' and injects
     * a the stage, IDomainContact and CommandConverter.
     */
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

    /**
     * This method is used for sending a pop-up message, alerting the user if
     * the user has ben inactive for a certain amount of time. If the user 
     * clicks 'OK' on the alertMenu, resetTimer() is called in IDomainContact
     * to reset the timed thread.
     */
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
                alertMenu.setHeaderText("Du bliver logget ud i løbet af 1 minut\nKlik på OK for at undgå dette");
                alertMenu.getButtonTypes().setAll(OKBtn);
                
                alertMenu.getDialogPane().setPrefSize(390, 80);
                
                alertMenu.showAndWait();
                
                IDC.resetTimer();
            }
        });
    }  

    /**
     * This handler is used for quickly fill out the textfields automatically.
     * If the CPR number entered, is found in the CPR register, the textfields
     * name, gender, birthday and adress will be auto-filled. This method
     * can be used upon creating an case reqeust.
     * @param event 
     */
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

    /**
     * This controller handles the create case button. The method checks the
     * which values in the gui formular is selceted and stores them in local
     * variables. When all the information is gathered, the method 
     * performCommand is called, with the reference to CommandConveter. 
     * All the stored information in the local varbiales are sent to the 
     * perfomCommand call.
     * @param event 
     */
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
        clearSagFields();
    }

    /**
     * This controller handles the create employee button. The methoder checks
     * for which radio button is selceted, to controll which type of employee
     * and positon number must be given upon create.
     * @param event 
     */
    @FXML
    private void HandleopretAnsat(ActionEvent event) {
        
        int i = 0;
        if (sagsbehandlerRadio.isSelected()) {
            i = 2;
            CC.performCommand("addemployee", opretCPR.getText(), opretNavn.getText(), opretKøn.getText(), opretFødselsdag.getText(), opretAdresse.getText(), opretTelefon.getText(), opretEmail.getText(), opretBrugernavn.getText(), opretAdgangskode.getText(), Integer.toString(i));
            clearOpretFields();
        } else if (sekretærRadio.isSelected()) {
            i = 1;
            CC.performCommand("addemployee", opretCPR.getText(), opretNavn.getText(), opretKøn.getText(), opretFødselsdag.getText(), opretAdresse.getText(), opretTelefon.getText(), opretEmail.getText(), opretBrugernavn.getText(), opretAdgangskode.getText(), Integer.toString(i));
            clearOpretFields();
        } else if (adminRadio.isSelected()) {
            i = 3;
            CC.performCommand("addemployee", opretCPR.getText(), opretNavn.getText(), opretKøn.getText(), opretFødselsdag.getText(), opretAdresse.getText(), opretTelefon.getText(), opretEmail.getText(), opretBrugernavn.getText(), opretAdgangskode.getText(), Integer.toString(i));
            clearOpretFields();
        } else if (sletAnsatRadio.isSelected()) {
            if (Integer.parseInt(deleteEmployeeID.getText()) != DomainContact.getInstance().getCurrentUser().getId()) {
                CC.performCommand("deleteemployee", deleteEmployeeID.getText());
            } else {
                deleteEmployeeID.setText("Kan ikke slette dig selv");
                opretNavn.setVisible(false);
                opretAdresse.setVisible(false);
                opretBrugernavn.setVisible(false);
            }
            clearOpretFields();
        }
    }

    /**
     * This handler is used for quickly fill out the textfields automatically.
     * If the CPR number entered, is found in the CPR register, the textfields
     * name, gender, birthday and adress will be auto-filled. This method
     * can be used upon creating an employee.
     * @param event 
     */
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

    
    /**
     * This controller is used for the button 'handleGåtTil' dropDown scene 
     * when searching for an CPR number. If the CPR has have any caserequests 
     * a case can be created with the associated caserequest.  The button 
     * changes the scene to the create case stage, where the formular is shown.
     * 
     * If the CPR has cases which can be shown, the button will set the
     * scene to 'create case formular', showing all the information the  case
     * has. It is possible to change the information by editing them.
     * @param event 
     */
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
                if (PHPOAReturnString.length() > 8) 
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

    /**
     * This method handles the ''search'' stage and controlls which information
     * should be displayed when clicking on the dropdown menu. The items displ-
     * ayed in the dropdown uses an observablelist, where the cases and employe
     * id are updated upon clicking on a new case or caserequest.
     * @param event 
     */
    @FXML
    private void handDropDown(MouseEvent event) {
        beskrivelse.setVisible(true);
        oprettetAf.setVisible(true);
        if (!(IDC.getCurrentUser() instanceof Secretary)) 
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

    /**
     * Overirreden method from IIjectableController
     * @param stage 
     */
    @Override
    public void injectStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Overirreden method from IIjectableController
     * @param IDC 
     */
    @Override
    public void injectDomainContact(IDomainContact IDC)
    {
        this.IDC = IDC;
    }

    /**
     * Overirreden method from IIjectableController
     * @param commandConverter 
     */
    @Override
    public void injectCommandConverter(CommandConverter commandConverter) {
        this.CC = commandConverter;
    }

    /**
     * This method handles the delete button under 'opret ansat' scene. 
     * It enables some of the informationfields, so that the user can keep
     * track of which person was deleted.
     * @param event 
     */
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

    /**
     * this method is almost identical to create case, but the method is called
     * editCase in CommandConverter. This method assures that the existing case
     * is replaced with the new case which has been edited.
     * @param event 
     */
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
