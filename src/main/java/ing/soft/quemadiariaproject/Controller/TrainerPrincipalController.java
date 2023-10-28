package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class TrainerPrincipalController {
    public Button buttonLogout;
    public Label usernameLabel;
    public Label specialityLabel;
    public Button buttonAccount;
    public Button buttonStatistics;
    public Button buttonWallet;
    public Button buttonPrograms;
    public ImageView accountIcon;
    private TrainerDTO trainerDTO;
    public void initialize(){
        trainerDTO = CentralController.getTrainerDTO();
        usernameLabel.setText(trainerDTO.getUsername());
        specialityLabel.setText(trainerDTO.getSpeciality());
    }
    public void logout(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("Welcome.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToAccount(MouseEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerAccount.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToStatistics(MouseEvent actionEvent) {

    }

    public void goToWallet(MouseEvent actionEvent) {

    }

    public void goToPrograms(MouseEvent actionEvent) {

    }

    public void goAccount(MouseEvent mouseEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerAccount.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
