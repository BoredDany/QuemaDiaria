package ing.soft.quemadiaria;

import ing.soft.quemadiaria.Controller.CentralController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        CentralController.getInstance().loadScreen("Welcome.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}