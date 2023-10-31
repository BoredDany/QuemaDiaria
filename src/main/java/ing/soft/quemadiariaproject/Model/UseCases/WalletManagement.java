package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Controller.CentralController;
import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.DTOs.WalletDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Wallet;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.WalletException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceWallet;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.Persistence;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceWallet;

import java.util.ArrayList;
import java.util.List;

public class WalletManagement {
    private PersistenceWallet persistence;
    public WalletManagement(PersistenceWallet persistence){
        this.persistence = persistence;
    }

    public void verifyFullFields(WalletDTO wallet) throws WalletException {
        if (wallet.getTrainerUsername().isEmpty() || wallet.getAccountNumber().isEmpty()
                || wallet.getBankName().isEmpty() || wallet.getAccountType().isEmpty()) {
            throw new WalletException("Missing information");
        }
    }

    public void addWallet(WalletDTO wallet) throws WalletException {
        verifyFullFields(wallet);
        Wallet newWallet = new Wallet(wallet.getTrainerUsername(), wallet.getAccountNumber(), wallet.getBankName(), wallet.getAccountType());
        persistence.saveWallet(newWallet);
    }

}
