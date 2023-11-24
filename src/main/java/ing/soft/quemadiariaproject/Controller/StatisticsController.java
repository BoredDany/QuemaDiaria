package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Entities.Program;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceProg;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceProg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    PersistenceProg persistence = new FilePersistenceProg();
    public double totalViews=0;
    public double totalLikes=0;
    @FXML
    public void initialize() {

        List<Program> programs = persistence.consultProgramsList();
        for (int i = 0; i < programs.size(); i++) {
            Program program = programs.get(i);
            totalViews+=program.getViews();
            totalLikes+=program.getLikes();
        }
        viewsSum.setVisible(true);
        viewsSum.setText(String.valueOf(totalViews));
        likesSum.setVisible(true);
        likesSum.setText(String.valueOf(totalLikes));
        showPrograms();
    }

    public void goToPrincipalTrainer (ActionEvent actionEvent){
        try {
            CentralController.getInstance().loadScreen("TrainerPrincipal.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setProgramDetails (Label name, Label likes, Label views, Program program, Label likesPercentage, Label viewsPercentage){
        name.setVisible(true);
        name.setText(program.getName());
        likes.setVisible(true);
        likes.setText(String.valueOf(program.getLikes()));
        views.setVisible(true);
        views.setText(String.valueOf(program.getViews()));
        double totalLikesPercentage = ((double) program.getLikes() /  totalLikes)*100;
        double totalViewsPercentage = ((double) program.getViews() / totalViews)*100;
        DecimalFormat formato = new DecimalFormat("#.##");
        String numeroFormateado = formato.format(totalLikesPercentage);
        likesPercentage.setVisible(true);
        likesPercentage.setText(String.valueOf(numeroFormateado) + "%");
        String numeroFormateado2 = formato.format(totalViewsPercentage);
        viewsPercentage.setVisible(true);
        viewsPercentage.setText(String.valueOf(numeroFormateado2) + "%");

    }
    public void showPrograms () {

        List<Program> programs = persistence.consultProgramsList();

        if (!programs.isEmpty()) {
            setProgramDetails(name1, likes1, views1, programs.get(0),likesPercentage1, viewsPercentage1);
        }
        if (programs.size() > 1) {
            setProgramDetails(name2, likes2, views2, programs.get(1),likesPercentage2, viewsPercentage2);
        }
        if (programs.size() > 2) {
            setProgramDetails(name3, likes3, views3, programs.get(2),likesPercentage3, viewsPercentage3);
        }

    }
}

