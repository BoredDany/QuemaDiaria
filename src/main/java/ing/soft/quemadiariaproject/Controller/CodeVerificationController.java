package ing.soft.quemadiariaproject.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;

public class CodeVerificationController {

    public Button iniciarSesionButton;
    @FXML
    private TextField codigoField;

    @FXML
    private void confirmarCodigo() throws IOException {
        String codigoIngresado = codigoField.getText();
        String codigoCorrecto = "886645"; // Reemplaza con el código correcto

        if (codigoIngresado.equals(codigoCorrecto)) {
            mostrarMensaje("Código correcto. ¡Cuenta activada!");

        } else {
            mostrarMensaje("Código incorrecto. Intenta nuevamente.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Getter para codigoField
    public TextField getCodigoField() {
        return codigoField;
    }

    // Setter para codigoField
    public void setCodigoField(TextField codigoField) {
        this.codigoField = codigoField;
    }

    public void goToWelcome(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("Welcome.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


