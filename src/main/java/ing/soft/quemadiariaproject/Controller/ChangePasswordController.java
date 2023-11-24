package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.AccountFacade;
import ing.soft.quemadiariaproject.Model.Facade.AccountService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangePasswordController {
    public TextField currentPsswordField;
    public TextField newPasswordField;
    public TextField confirmationField;
    public Button buttonChangePassword;
    public Label errLabel;
    private AccountFacade modifyData = new AccountService();

    public void changePassword(ActionEvent actionEvent) {
        String oldPassword = currentPsswordField.getText();
        String newPassword = newPasswordField.getText();
        String confirmationnew = confirmationField.getText();
        try{
            modifyData.modifyPassword(oldPassword, newPassword,
                    confirmationnew, CentralController.getTrainerDTO().getUsername());
            Stage stage = (Stage) buttonChangePassword.getScene().getWindow();
            stage.close();
            CentralController.getInstance().loadScreen("Welcome.fxml");
        }catch (TrainerException e){
            errLabel.setText(e.getMessage());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
