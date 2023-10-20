package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CentralController {
    private static CentralController centralController;
    private static Stage stage;
    public static CentralController getInstance(){
        if(centralController == null){
            stage = new Stage();
            centralController = new CentralController();
        }
        return centralController;
    }
    public void loadScreen(String file) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(file));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

}
