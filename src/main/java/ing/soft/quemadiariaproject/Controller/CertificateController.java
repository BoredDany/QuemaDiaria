package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Facade.AccountFacade;
import ing.soft.quemadiariaproject.Model.Facade.AccountService;
import ing.soft.quemadiariaproject.Model.Facade.CertificateFacade;
import ing.soft.quemadiariaproject.Model.Facade.CertificateService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CertificateController {
    public Button buttonBack;
    public TextField titleField;
    public TextField institutionField;
    public TextField descriptionField;
    public TextField linkField;
    public Button buttonSaveCertif;
    public Label errCertifLabel;
    public DatePicker dateField;
    private CertificateFacade registerCertificate = new CertificateService();
    public void cleanErrLabels(){
        errCertifLabel.setText("");
    }
    public void goToAccount(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerAccount.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getDate(){
        String date = null;
        if(dateField.getValue() != null){
            LocalDate selectedDate = dateField.getValue();
            int day = selectedDate.getDayOfMonth();
            int month = selectedDate.getMonthValue();
            int year = selectedDate.getYear();
            date = day + "/" + month + "/" + year;
        }
        return date;
    }
    public CertificateDTO getCertInfo(){
        String username = CentralController.getTrainerDTO().getUsername();
        String institution = institutionField.getText();
        String expDate = getDate();
        String description = descriptionField.getText();
        String link = linkField.getText();
        String title = titleField.getText();
        CertificateDTO certificateDTO = new CertificateDTO(username, institution, expDate,
                description, link, title);
        return certificateDTO;
    }
    public void saveCertif(ActionEvent actionEvent) {
        try {
            cleanErrLabels();
            registerCertificate.saveCertificate(getCertInfo());
            errCertifLabel.setText("Certificate saved");
        } catch (TrainerException e){
            errCertifLabel.setText(e.getMessage());
        } catch(Exception ec){
            ec.printStackTrace();
        }
    }
}
