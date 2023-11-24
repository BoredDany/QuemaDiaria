package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.AccountFacade;
import ing.soft.quemadiariaproject.Model.Facade.AccountService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WelcomeController {

    public TextField usernameField;
    public TextField passwordField;
    public Button buttonLogin;
    public Button buttonSignUp;
    public Label errLabel;
    private AccountFacade login = new AccountService();

    public void login(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        try{
            login.doLogin(username, password);
            CentralController.getInstance().loadScreen("TrainerPrincipal.fxml");
        }catch(TrainerException | IOException e){
            errLabel.setText(e.getMessage());
        }
    }

    public void signUp(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("SignUp.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
