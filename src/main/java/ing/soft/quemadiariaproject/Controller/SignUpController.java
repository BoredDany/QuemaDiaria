package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.TrainerFacade;
import ing.soft.quemadiariaproject.Model.Facade.TrainerServices;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpController {
    public TextField nameField;
    public TextField idField;
    public TextField emailField;
    public TextField usernameField;
    public TextField passwordField;
    public Button buttonSignUp;

    public void signUp(ActionEvent actionEvent) {
        String name = nameField.getText();
        String identification = idField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        try{
            TrainerFacade register = new TrainerServices();
            Trainer newTrainer = new Trainer(name, identification, email, new Credential(username, password));
            register.registerTrainer(newTrainer);
            System.out.println("Saved successfully: " + newTrainer);
        }catch(TrainerException e){
            System.out.println(e.getMessage());
        }
    }

}
