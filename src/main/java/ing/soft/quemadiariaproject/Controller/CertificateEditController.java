package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.CertificateFacade;
import ing.soft.quemadiariaproject.Model.Facade.CertificateService;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class CertificateEditController {
    public Button buttonBack;
    public Button buttonSaveTitle;
    public Button buttonSaveInstit;
    public Button buttonSaveExpDate;
    public Button buttonSaveDescrip;
    public Button buttonSaveLink;
    public Label errTitleLabel;
    public Label errInstitLabel;
    public Label errDateLabel;
    public Label errDescriptLabel;
    public Label errLinkLabel;
    public TextField titleField;
    public TextField institutionField;
    public TextField descriptionField;
    public DatePicker expDateField;
    public TextField linkField;
    public Hyperlink buttonHyperlink;
    private CertificateFacade certificateFacade = new CertificateService();

    public void getDate(){
        String infoDate = CentralController.getCertificateDTO().getExpeditionDate();
        String[] infoDateArr = infoDate.split("/");
        int year = Integer.parseInt(infoDateArr[2]);
        int month = Integer.parseInt(infoDateArr[1]);
        int day = Integer.parseInt(infoDateArr[0]);
        LocalDate selectedDate = LocalDate.of(year, month, day);
        expDateField.setValue(selectedDate);
    }
    public void initialize(){
        titleField.setText(CentralController.getCertificateDTO().getTitle());
        institutionField.setText(CentralController.getCertificateDTO().getInstitution());
        descriptionField.setText(CentralController.getCertificateDTO().getDescription());
        getDate();
        linkField.setText(CentralController.getCertificateDTO().getLink());
    }
    public void cleanErrLabels(){
        errTitleLabel.setText(" ");
        errInstitLabel.setText(" ");
        errDateLabel.setText(" ");
        errDescriptLabel.setText(" ");
        errLinkLabel.setText(" ");
    }

    public void goToAccount(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerAccount.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTitle(ActionEvent actionEvent) {
    }

    public void saveInstitution(ActionEvent actionEvent) {
    }

    public void saveExpDate(ActionEvent actionEvent) {
    }

    public void saveDescription(ActionEvent actionEvent) {
    }

    public void saveLink(ActionEvent actionEvent) {
    }

    public void goToHyperlink(ActionEvent actionEvent) {
    }
}
