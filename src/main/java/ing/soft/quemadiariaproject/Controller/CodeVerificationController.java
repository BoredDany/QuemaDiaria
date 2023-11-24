package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.AccountFacade;
import ing.soft.quemadiariaproject.Model.Facade.AccountService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CodeVerificationController {
    public Button btnConfirm;
    public Label errCode;
    public Button btnBackSignUp;
    public TextField fieldCode;

    private AccountFacade register = new AccountService();

    public void confirmCode(ActionEvent actionEvent) {
        try{
            if(fieldCode.getText().equals(String.valueOf(CentralController.getConfirmationCode()))){
                register.registerTrainer(CentralController.getTrainerDTO(), CentralController.getPassword());
                mostrarMensaje("Código correcto. ¡Cuenta activada!");
                CentralController.setConfirmationCode(0);
                goToLogin();
            }else{
                mostrarMensaje("Código incorrecto. Intenta nuevamente.");
            }
        } catch (TrainerException e){
            mostrarMensaje(e.getMessage());
        }

    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void goToSignUp(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("SignUp.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToLogin() {
        try {
            CentralController.getInstance().loadScreen("Welcome.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
