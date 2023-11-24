package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Entities.EmailSender;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.AccountFacade;
import ing.soft.quemadiariaproject.Model.Facade.AccountService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;


import static ing.soft.quemadiariaproject.Controller.CentralController.centralController;

public class SignUpController {
    public Label errrLabel;
    public TextField nameField;
    public TextField idField;
    public TextField emailField;
    public TextField usernameField;
    public TextField passwordField;
    public Button buttonSignUp;
    public Button buttonBack;
    public Button buttonCode;
    private AccountFacade register = new AccountService();
    public void signUp(ActionEvent actionEvent) {
        String name = nameField.getText();
        String identification = idField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        try{
            TrainerDTO trainerDTO = new TrainerDTO(name, identification, email, username);
            register.registerTrainer(trainerDTO, password);
            errrLabel.setText("Saved successfully");
        }catch(TrainerException e){
            errrLabel.setText(e.getMessage());
        }

        EmailSender.sendConfirmationEmail(email);


    }

    public void goToWelcome(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("Welcome.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToCode(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("CodeVerification.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
