package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistence;
import ing.soft.quemadiariaproject.Model.UseCases.Register;
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
        if(!name.isEmpty() && !identification.isEmpty() && !email.isEmpty()){
            try{
                Register register = new Register(new FilePersistence());
                Trainer newTrainer = new Trainer(name, identification, email, new Credential(username, password));
                register.registerTrainer(newTrainer);
            }catch(TrainerException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Information is missing");
    }
}
