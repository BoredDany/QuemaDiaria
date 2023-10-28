package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.HelloApplication;
import ing.soft.quemadiariaproject.Model.DTOs.TrainerDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CentralController {
    private static CentralController centralController;
    private static Stage stage;
    private static TrainerDTO trainerDTO;
    public static CentralController getInstance(){
        if(centralController == null){
            stage = new Stage();
            centralController = new CentralController();
            trainerDTO = new TrainerDTO();
        }
        return centralController;
    }
    public static void setTrainerDTO(TrainerDTO trainerDto){
        trainerDTO = trainerDto;
    }
    public static TrainerDTO getTrainerDTO(){
        return trainerDTO;
    }
    public void loadScreen(String file) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(file));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    public void openScreen(String file) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(file));
        Stage newStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        newStage.setScene(scene);
        newStage.show();
    }

}
