package ing.soft.quemadiariaproject.Controller;

import ing.soft.quemadiariaproject.Model.DTOs.WalletDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Wallet;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.WalletException;
import ing.soft.quemadiariaproject.Model.Facade.WalletFacade;
import ing.soft.quemadiariaproject.Model.Facade.WalletService;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceWallet;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceWallet;
import ing.soft.quemadiariaproject.Model.UseCases.WalletManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TrainerWalletController {

    public TextField accNumberField;
    public TextField bankField;
    public Button buttonSave;
    public Button buttonBack;
    public TextField accountTypeField;
    public Label errAccLabel;
    private WalletFacade walletFacade = new WalletService();
    @FXML
    public void initialize() {
        walletFacade.getWallet(CentralController.getTrainerDTO().getUsername());
        if(CentralController.getWalletDTO() != null){
            accNumberField.setText(CentralController.getWalletDTO().getAccountNumber());
            bankField.setText(CentralController.getWalletDTO().getBankName());
            accountTypeField.setText(CentralController.getWalletDTO().getAccountType());
        }
    }

    public void saveAccount(ActionEvent actionEvent) {
        try {
            String numeroCuenta = accNumberField.getText();
            String nombreBanco = bankField.getText();
            String tipoCuenta = accountTypeField.getText();
            WalletDTO newWallet = new WalletDTO(CentralController.getTrainerDTO().getUsername(),
                    numeroCuenta, nombreBanco, tipoCuenta);
            walletFacade.saveWallet(newWallet);
            errAccLabel.setText("Wallet saved");
        } catch (WalletException e) {
            errAccLabel.setText(e.getMessage());
        }

    }

    public void goToPrincipal(ActionEvent actionEvent) {
        try {
            CentralController.getInstance().loadScreen("TrainerPrincipal.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
