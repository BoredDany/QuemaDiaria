package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Program;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Facade.ProgramFacade;
import ing.soft.quemadiariaproject.Model.Facade.ProgramService;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceProg;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceProg;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainerProgramsController {

    public Button buttonBack;
    public ListView programsListView;
    public Label usernameField;

    ProgramFacade programFacade = new ProgramService();

    @FXML
    public void initialize() {
        usernameField.setText(CentralController.getTrainerDTO().getUsername() + "'s programs");
        ObservableList<String> observableItems =
                FXCollections.observableArrayList(
                        programFacade.programsResume(
                                CentralController.getTrainerDTO().getUsername()));
        programsListView.setItems(observableItems);
    }

    public void goToPrincipalTrainer(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerPrincipal.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}