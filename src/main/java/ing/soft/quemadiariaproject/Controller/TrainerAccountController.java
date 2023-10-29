package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.TrainerFacade;
import ing.soft.quemadiariaproject.Model.Facade.TrainerServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TrainerAccountController {

    public TextField nameField;
    public TextField identificationField;
    public TextField emailField;
    public TextField specialityField;
    public TextField usernameField;
    public TextField newSocialmediaField;
    public TextField newCertifiateField;
    public ListView socialmediaList;
    public ListView certificatesList;
    public Button buttonBack;
    public Button buttonChangeName;
    public Button buttonChangeId;
    public Button buttonChangeEmail;
    public Button buttonChangeSpeciality;
    public Button buttonChangeUsername;
    public Button buttonAddSocialmedia;
    public Button buttonAddCertificate;
    public Button buttonChangePassword;
    public Button buttonRemoveSocialmedia;
    public Label errPersonalInfoLabel;
    public Label errSocialmediaLabel;
    public Label errAccInfoLabel;

    private TrainerFacade modifyData = new TrainerServices();
    public void initialize(){
        nameField.setText(CentralController.getTrainerDTO().getName());
        identificationField.setText(CentralController.getTrainerDTO().getIdentification());
        emailField.setText(CentralController.getTrainerDTO().getEmail());
        specialityField.setText(CentralController.getTrainerDTO().getSpeciality());
        usernameField.setText(CentralController.getTrainerDTO().getUsername());
        List<String>items = CentralController.getTrainerDTO().getSocialMedia();
        ObservableList<String> observableItems = FXCollections.observableArrayList(items);
        socialmediaList.setItems(observableItems);
    }
    public void cleanErrLabels(){
        errPersonalInfoLabel.setText("");
        errSocialmediaLabel.setText("");
        errAccInfoLabel.setText("");
    }
    public void goToPrincipalTrainer(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerPrincipal.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeName(ActionEvent actionEvent) {
        String newName = nameField.getText();
        try{
            cleanErrLabels();
            modifyData.modifyName(newName, CentralController.getTrainerDTO());
            initialize();
            errPersonalInfoLabel.setText("Name saved");
        }catch(TrainerException e){
            errPersonalInfoLabel.setText(e.getMessage());
        }
    }

    public void changeId(ActionEvent actionEvent) {
        String newId = identificationField.getText();
        try{
            cleanErrLabels();
            modifyData.modifyID(newId, CentralController.getTrainerDTO());
            initialize();
            errPersonalInfoLabel.setText("ID saved");
        }catch(TrainerException e){
            errPersonalInfoLabel.setText(e.getMessage());
        }
    }

    public void changeEmail(ActionEvent actionEvent) {
        String newEmail = emailField.getText();
        try{
            cleanErrLabels();
            modifyData.modifyEmail(newEmail, CentralController.getTrainerDTO());
            initialize();
            errPersonalInfoLabel.setText("Email saved");
        }catch(TrainerException e){
            errPersonalInfoLabel.setText(e.getMessage());
        }
    }

    public void changeSpeciality(ActionEvent actionEvent) {
        String newSpeciality = specialityField.getText();
        try{
            cleanErrLabels();
            modifyData.modifySpeciality(newSpeciality, CentralController.getTrainerDTO());
            initialize();
            errAccInfoLabel.setText("Speciality saved");
        }catch(TrainerException e){
            errAccInfoLabel.setText(e.getMessage());
        }
    }

    public void addSocialmedia(ActionEvent actionEvent) {
        String newSocialmedia = newSocialmediaField.getText();
        try{
            cleanErrLabels();
            modifyData.addSocialmedia(newSocialmedia, CentralController.getTrainerDTO());
            initialize();
            errSocialmediaLabel.setText("Socialmedia added");
        }catch(TrainerException e){
            errSocialmediaLabel.setText(e.getMessage());
        }
    }
    public void removeSocialmedia(ActionEvent actionEvent) {
        try {
            cleanErrLabels();
            String deleteSocialmedia = (String) socialmediaList.getSelectionModel().getSelectedItem();
            modifyData.removeSocialmedia(deleteSocialmedia, CentralController.getTrainerDTO());
            initialize();
            errSocialmediaLabel.setText("Socialmedia deleted");
        }catch(TrainerException e){
            errSocialmediaLabel.setText(e.getMessage());
        }

    }
    public void addCertificate(ActionEvent actionEvent) {

    }
    public void changeUsername(ActionEvent actionEvent) {
        String newUsername = usernameField.getText();
        try{
            cleanErrLabels();
            modifyData.modifyUsername(newUsername, CentralController.getTrainerDTO());
            initialize();
            errAccInfoLabel.setText("Username saved");
        }catch(TrainerException e){
            errAccInfoLabel.setText(e.getMessage());
        }
    }
    public void goToChangePassword(ActionEvent actionEvent) {
        try{
            CentralController.getInstance().openScreen("ChangePassword.fxml");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
