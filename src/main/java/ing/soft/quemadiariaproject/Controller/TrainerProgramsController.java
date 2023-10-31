package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Program;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceProg;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceProg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainerProgramsController {

    private static Trainer c;
    @FXML
    public Label name1, name2, name3;
    @FXML
    public Label duration1, duration2, duration3;
    @FXML
    public Label likes1, likes2, likes3;
    @FXML
    public Label views1, views2, views3;

    PersistenceProg persistence = new FilePersistenceProg();

    public TrainerProgramsController() {
    }

    @FXML
    public void initialize() {
        hideAllLabels();
        showPrograms();
    }

    private void hideAllLabels() {
        name1.setVisible(false);
        name2.setVisible(false);
        name3.setVisible(false);
        duration1.setVisible(false);
        duration2.setVisible(false);
        duration3.setVisible(false);
        likes1.setVisible(false);
        likes2.setVisible(false);
        likes3.setVisible(false);
        views1.setVisible(false);
        views2.setVisible(false);
        views3.setVisible(false);
    }

    String username = CentralController.getTrainerDTO().getUsername();

    public void showPrograms() {

        List<Program> programs = persistence.consultProgramsList();
        List<Program> programsUser = new ArrayList<>();

        for(Program p : programs){
            if(p.getTrainerUsername().equals(username)){
                programsUser.add(p);
            }
        }
        if(programsUser != null) {
            if (!programsUser.isEmpty()) {
                setProgramDetails(name1, duration1, likes1, views1, programsUser.get(0));
            }
            if (programsUser.size() > 1) {
                setProgramDetails(name2, duration2, likes2, views2, programsUser.get(1));
            }
            if (programsUser.size() > 2) {
                setProgramDetails(name3, duration3, likes3, views3, programsUser.get(2));
            }
        }
    }

    public void setProgramDetails(Label name, Label duration, Label likes, Label views, Program program) {
        name.setVisible(true);
        name.setText(program.getName());
        duration.setVisible(true);
        duration.setText(program.getDuration());
        likes.setVisible(true);
        likes.setText(String.valueOf(program.getLikes()));
        views.setVisible(true);
        views.setText(String.valueOf(program.getViews()));
    }

    public void goToPrincipalTrainer(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerPrincipal.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}