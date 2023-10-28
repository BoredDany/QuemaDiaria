package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.TrainerFacade;
import ing.soft.quemadiariaproject.Model.Facade.TrainerServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
            modifyData.modifyName(newName, CentralController.getTrainerDTO());
            initialize();
            System.out.println("Name modified");
        }catch(TrainerException e){
            System.out.println(e.getMessage());
        }
    }

    public void changeId(ActionEvent actionEvent) {
        String newId = identificationField.getText();
        try{
            modifyData.modifyID(newId, CentralController.getTrainerDTO());
            initialize();
            System.out.println("ID modified");
        }catch(TrainerException e){
            System.out.println(e.getMessage());
        }
    }

    public void changeEmail(ActionEvent actionEvent) {
        String newEmail = emailField.getText();
        try{
            modifyData.modifyEmail(newEmail, CentralController.getTrainerDTO());
            initialize();
            System.out.println("Email modified");
        }catch(TrainerException e){
            System.out.println(e.getMessage());
        }
    }

    public void changeSpeciality(ActionEvent actionEvent) {
        String newSpeciality = specialityField.getText();
        try{
            modifyData.modifySpeciality(newSpeciality, CentralController.getTrainerDTO());
            initialize();
            System.out.println("Speciality modified");
        }catch(TrainerException e){
            System.out.println(e.getMessage());
        }
    }

    public void addSocialmedia(ActionEvent actionEvent) {
        String newSocialmedia = newSocialmediaField.getText();
        try{
            modifyData.addSocialmedia(newSocialmedia, CentralController.getTrainerDTO());
            initialize();
            System.out.println("Socialmedia added");
        }catch(TrainerException e){
            System.out.println(e.getMessage());
        }
    }
    public void removeSocialmedia(ActionEvent actionEvent) {
        String deleteSocialmedia = (String) socialmediaList.getSelectionModel().getSelectedItem();
        modifyData.removeSocialmedia(deleteSocialmedia, CentralController.getTrainerDTO());
        initialize();
        System.out.println("Socialmedia deleted");
    }
    public void addCertificate(ActionEvent actionEvent) {

    }
    public void changeUsername(ActionEvent actionEvent) {
        String newUsername = usernameField.getText();
        try{
            modifyData.modifyUsername(newUsername, CentralController.getTrainerDTO());
            initialize();
            System.out.println("Username changed");
        }catch(TrainerException e){
            System.out.println(e.getMessage());
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
