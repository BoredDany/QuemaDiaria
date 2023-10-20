package ing.soft.quemadiaria.Controller;

import ing.soft.quemadiaria.Model.Domain.Entities.Trainer;
import ing.soft.quemadiaria.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiaria.Model.Persistence.Files.FilePersistence;
import ing.soft.quemadiaria.Model.UseCases.Login;
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
        if(!username.isEmpty() && !password.isEmpty()){
            Login login = new Login(new FilePersistence());
            try{
                login.doLogin(username, password);
            }catch(TrainerException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Information is missing");
    }

    public void signUp(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("SignUp.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
