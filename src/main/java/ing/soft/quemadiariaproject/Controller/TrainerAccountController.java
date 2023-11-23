package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.AccountFacade;
import ing.soft.quemadiariaproject.Model.Facade.AccountService;
import ing.soft.quemadiariaproject.Model.Facade.CertificateFacade;
import ing.soft.quemadiariaproject.Model.Facade.CertificateService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
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
    public Label errCertifLabel;
    public Button btnDeleteCert;
    public Button btnOpenCert;
    private AccountFacade modifyData = new AccountService();
    private CertificateFacade certificateFacade = new CertificateService();
    public void getSocialmedia(){
        if(CentralController.getTrainerDTO().getSocialMedia() != null){
            List<String>items = CentralController.getTrainerDTO().getSocialMedia();
            ObservableList<String> observableItems = FXCollections.observableArrayList(items);
            socialmediaList.setItems(observableItems);
        }
    }
    public void getCertificates(){
        ObservableList<String> observableItems = FXCollections.observableArrayList(certificateFacade.getResumeCert());
        certificatesList.setItems(observableItems);
    }
    public void initialize(){
        nameField.setText(CentralController.getTrainerDTO().getName());
        identificationField.setText(CentralController.getTrainerDTO().getIdentification());
        emailField.setText(CentralController.getTrainerDTO().getEmail());
        specialityField.setText(CentralController.getTrainerDTO().getSpeciality());
        usernameField.setText(CentralController.getTrainerDTO().getUsername());
        getSocialmedia();
        getCertificates();
    }
    public void cleanErrLabels(){
        errPersonalInfoLabel.setText("");
        errSocialmediaLabel.setText("");
        errAccInfoLabel.setText("");
        errCertifLabel.setText("");
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
    public void addCertificate(ActionEvent actionEvent) {
        try{
            CentralController.getInstance().loadScreen("Certificate.fxml");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void getInfoCertificate(MouseEvent mouseEvent) {
        /*String username = CentralController.getTrainerDTO().getUsername();
        String infoCert = (String) certificatesList.getSelectionModel().getSelectedItem();
        String[] dataCert = infoCert.split("\n");
        String title = dataCert[0];
        String institution = dataCert[1];
        String expDate = dataCert[2];
        CertificateDTO certificateDTO = certificateFacade.getCertificate(username, title, institution, expDate);
        CentralController.setCertificateDTO(certificateDTO);*/
    }

    public CertificateDTO getSelectedCertificate(){
        CertificateDTO certificateDTO = null;
        if(!((certificatesList.getSelectionModel().getSelectedItem()) == null)){
            String username = CentralController.getTrainerDTO().getUsername();
            String infoCert = (String) certificatesList.getSelectionModel().getSelectedItem();
            String[] dataCert = infoCert.split("\n");
            String title = dataCert[0];
            String institution = dataCert[1];
            String expDate = dataCert[2];
            certificateDTO = certificateFacade.getCertificate(username, title, institution, expDate);
        }
        return certificateDTO;
    }

    public void openCertificate() {
        try {
            CentralController.setCertificateDTO(getSelectedCertificate());
            if(CentralController.getCertificateDTO() != null){
                CentralController.getInstance().loadScreen("CertificateEdit.fxml");
            }
            else{
                errCertifLabel.setText("Any selected");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCertificate() {
        try {
            CentralController.setCertificateDTO(getSelectedCertificate());
            if(CentralController.getCertificateDTO() != null){
                certificateFacade.deleteCertificate(CentralController.getCertificateDTO());
                errCertifLabel.setText("Certificate deleted");
                getCertificates();
            }
            else{
                errCertifLabel.setText("Any selected");
            }
        } catch (TrainerException e) {
            errCertifLabel.setText(e.getMessage());
        }
    }
}
