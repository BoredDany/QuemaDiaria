package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.DTOs.ProgramDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Program;
import ing.soft.quemadiariaproject.Model.Facade.ProgramFacade;
import ing.soft.quemadiariaproject.Model.Facade.ProgramService;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceProg;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceProg;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class StatisticsController {
    @FXML
    public Button buttonBack;

    @FXML
    public Label lblLikes;

    @FXML
    public Label lblProgramName;

    @FXML
    public Label lblViews;

    @FXML
    public Label likes1;

    @FXML
    public Label likes2;

    @FXML
    public Label likes3;

    @FXML
    public Label likesPercentage1;

    @FXML
    public Label likesPercentage2;

    @FXML
    public Label likesPercentage3;

    @FXML
    public Label likesSum;

    @FXML
    public Label name1;

    @FXML
    public Label name2;

    @FXML
    public Label name3;

    @FXML
    public Label views1;

    @FXML
    public Label views2;

    @FXML
    public Label views3;

    @FXML
    public Label viewsPercentage1;

    @FXML
    public Label viewsPercentage2;

    @FXML
    public Label viewsPercentage3;

    @FXML
    public Label viewsSum;
    public TableView tablePrograms;
    public Label labelLikes;
    public Label labelViews;
    public Label labelSubs;
    public Label labelAcom;
    public Label labelUserName;
    ProgramFacade programFacade = new ProgramService();

    @FXML
    public void initialize() {
        labelUserName.setText(CentralController.getTrainerDTO().getUsername()+"'s programs");
        List<ProgramDTO> userPrograms = programFacade.trainerProgramsStatistics(CentralController.getTrainerDTO().getUsername());
        createTable(userPrograms);
        labelAcom.setText(String.valueOf(programFacade.avgAcomp(userPrograms)));
        labelLikes.setText(String.valueOf(programFacade.avgLikes(userPrograms)));
        labelViews.setText(String.valueOf(programFacade.avgViews(userPrograms)));
        labelSubs.setText(String.valueOf(programFacade.avgSubs(userPrograms)));
    }

    public void createTable(List<ProgramDTO> userPrograms){
        ObservableList<ProgramDTO> observableUserPrograms = FXCollections.observableArrayList(userPrograms);
        TableColumn<ProgramDTO, String> nombreColumn = new TableColumn<>("Program");
        TableColumn<ProgramDTO, Integer> suscriptoresColumn = new TableColumn<>("Subscriptors");
        TableColumn<ProgramDTO, Integer> likesColumn = new TableColumn<>("Likes");
        TableColumn<ProgramDTO, Integer> vistasColumn = new TableColumn<>("Views");
        TableColumn<ProgramDTO, Integer> acomColumn = new TableColumn<>("% Acomplishment");

        nombreColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getName());
        });

        suscriptoresColumn.setCellValueFactory(cellData -> {
            int subscriptorsValue = cellData.getValue().getSubscriptors();
            return new SimpleIntegerProperty(subscriptorsValue).asObject();
        });

        likesColumn.setCellValueFactory(cellData -> {
            int likesValue = cellData.getValue().getLikes();
            return new SimpleIntegerProperty(likesValue).asObject();
        });

        vistasColumn.setCellValueFactory(cellData -> {
            int viewsValue = cellData.getValue().getViews();
            return new SimpleIntegerProperty(viewsValue).asObject();
        });

        acomColumn.setCellValueFactory(cellData -> {
            int acomplishmentValue = cellData.getValue().getAcomplishment();
            return new SimpleIntegerProperty(acomplishmentValue).asObject();
        });

        tablePrograms.getColumns().addAll(nombreColumn, suscriptoresColumn, likesColumn, vistasColumn, acomColumn);

        tablePrograms.setItems(observableUserPrograms);
    }

    public void goToPrincipalTrainer(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerPrincipal.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

