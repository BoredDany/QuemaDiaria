package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
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
        try{
            CertificateDTO old = CentralController.getCertificateDTO();
            CertificateDTO newCertificate = new CertificateDTO(old.getTrainerUsername(), old.getInstitution(), old.getExpeditionDate(), old.getDescription(), old.getLink(), titleField.getText());
            certificateFacade.modifyCertificate(CentralController.getCertificateDTO(), newCertificate);
            errTitleLabel.setText("Title modified and saved");
        } catch (TrainerException e){
            errTitleLabel.setText(e.getMessage());
        }
    }

    public void saveInstitution(ActionEvent actionEvent) {
        try{
            CertificateDTO old = CentralController.getCertificateDTO();
            CertificateDTO newCertificate = new CertificateDTO(old.getTrainerUsername(), institutionField.getText(), old.getExpeditionDate(), old.getDescription(), old.getLink(), old.getTitle());
            certificateFacade.modifyCertificate(CentralController.getCertificateDTO(), newCertificate);
            errInstitLabel.setText("Institution modified and saved");
        } catch (TrainerException e){
            errTitleLabel.setText(e.getMessage());
        }
    }

    public void saveExpDate(ActionEvent actionEvent) {
    }

    public void saveDescription(ActionEvent actionEvent) {
        try{
            CertificateDTO old = CentralController.getCertificateDTO();
            CertificateDTO newCertificate = new CertificateDTO(old.getTrainerUsername(), old.getInstitution(), old.getExpeditionDate(), descriptionField.getText(), old.getLink(), old.getTitle());
            certificateFacade.modifyCertificate(CentralController.getCertificateDTO(), newCertificate);
            errDescriptLabel.setText("Description modified and saved");
        } catch (TrainerException e){
            errTitleLabel.setText(e.getMessage());
        }
    }

    public void saveLink(ActionEvent actionEvent) {
        try{
            CertificateDTO old = CentralController.getCertificateDTO();
            CertificateDTO newCertificate = new CertificateDTO(old.getTrainerUsername(), old.getInstitution(), old.getExpeditionDate(), old.getDescription(), linkField.getText(), old.getTitle());
            certificateFacade.modifyCertificate(CentralController.getCertificateDTO(), newCertificate);
            errLinkLabel.setText("Link modified and saved");
        } catch (TrainerException e){
            errTitleLabel.setText(e.getMessage());
        }
    }

    public void goToHyperlink(ActionEvent actionEvent) {
    }
}
