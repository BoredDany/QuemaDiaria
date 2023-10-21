package ing.soft.quemadiariaproject.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class TrainerAccountController {
    public Button buttonLogout;
    public Label usernameLabel;
    public Label specialityLabel;
    public Button buttonAccount;
    public Button buttonStatistics;
    public Button buttonWallet;
    public Button buttonPrograms;

    public void logout(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("Welcome.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToAccount(ActionEvent actionEvent) {
    }

    public void goToStatistics(ActionEvent actionEvent) {
    }

    public void goToWallet(ActionEvent actionEvent) {
    }

    public void goToPrograms(ActionEvent actionEvent) {
    }
}
