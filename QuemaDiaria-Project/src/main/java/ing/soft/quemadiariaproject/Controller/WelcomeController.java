package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistence;
import ing.soft.quemadiariaproject.Model.UseCases.Login;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WelcomeController {

    public TextField usernameField;
    public TextField passwordField;
    public Button buttonLogin;
    public Button buttonSignUp;

    public void login(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Login login = new Login(new FilePersistence());
        try{
            login.doLogin(username, password);
        }catch(TrainerException e){
            System.out.println(e.getMessage());
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
