package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
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
    public TextField newSocialmediaLabel;
    public TextField newCertifiateLabel;
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

    public void initialize(){
        nameField.setText(CentralController.getTrainerDTO().getName());
        identificationField.setText(CentralController.getTrainerDTO().getIdentification());
        emailField.setText(CentralController.getTrainerDTO().getEmail());
        specialityField.setText(CentralController.getTrainerDTO().getSpeciality());
        usernameField.setText(CentralController.getTrainerDTO().getUsername());
        List<String>items = CentralController.getTrainerDTO().getSocialMedia();
        socialmediaList.setItems((ObservableList) items);

    }
    public void goToPrincipalTrainer(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerPrincipal.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeName(ActionEvent actionEvent) {
    }

    public void changeId(ActionEvent actionEvent) {
    }

    public void changeEmail(ActionEvent actionEvent) {
    }

    public void changeSpeciality(ActionEvent actionEvent) {
    }

    public void changeUsername(ActionEvent actionEvent) {
    }

    public void addSocialmedia(ActionEvent actionEvent) {
    }

    public void addCertificate(ActionEvent actionEvent) {
    }

    public void changePassword(ActionEvent actionEvent) {
    }
}
