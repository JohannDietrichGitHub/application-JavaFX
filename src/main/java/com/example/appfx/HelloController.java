package com.example.appfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextArea log_Area;
    @FXML
    private TextField experience_Area;
    @FXML
    private TextField presentation_Area;
    @FXML
    private TextField competences_Area;
    @FXML
    private TextField diplomes_Area;
    @FXML
    private ChoiceBox<String> contact_Display;
    @FXML
    private TextArea contenu_Contact_Area;

    private LogsManager logsManager;
    private CVManager cvManager;
    private ContactsManager contactsManager;
    private ModifCVManager ModifCVManager;
    private ShowContactManager ShowContactManager;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        logsManager = new LogsManager(log_Area);
        logsManager.displayLogs();

        cvManager = new CVManager(experience_Area, presentation_Area, competences_Area, diplomes_Area);
        cvManager.displayCVData();

        contactsManager = new ContactsManager(contact_Display, contenu_Contact_Area);
        contactsManager.populateContactChoiceBox();
    }

    @FXML
    protected void buttonModifCVClick(){
        ModifCVManager = new ModifCVManager(cvManager);
        ModifCVManager.modifyCV();
    }

    @FXML
    protected void buttonContactClick() {
        ShowContactManager showContactManager = new ShowContactManager(contactsManager, contenu_Contact_Area);
        showContactManager.showContact();
    }
}