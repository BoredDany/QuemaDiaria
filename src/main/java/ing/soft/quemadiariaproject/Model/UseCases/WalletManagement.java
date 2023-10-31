package ing.soft.quemadiariaproject.Model.UseCases;

import ing.soft.quemadiariaproject.Controller.CentralController;
import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.DTOs.WalletDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Certificate;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Credential;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Trainer;
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
    public void verifyExistingWallet(WalletDTO walletDTO) throws WalletException {
        if(persistence.walletExists(walletDTO)){
            throw new WalletException("Wallet belongs to another trainer");
        }
    }
    public void updateWallet(WalletDTO old, Wallet wallet){
        List<Wallet> wallets = persistence.consultWalletsList();
        for (int i = 0; i < wallets.size(); i++) {
            Wallet w = wallets.get(i);
            if (w.getTrainerUsername().equals(old.getTrainerUsername())) {
                wallets.set(i, wallet);
            }
        }
        persistence.updateFile(wallets);
    }

    public void addWallet(WalletDTO wallet) throws WalletException {
        verifyFullFields(wallet);
        verifyExistingWallet(wallet);
        Wallet newWallet = new Wallet(wallet.getTrainerUsername(), wallet.getAccountNumber(), wallet.getBankName(), wallet.getAccountType());
        if(CentralController.getWalletDTO() == null){
            persistence.saveWallet(newWallet);
        }else{
            updateWallet(wallet, newWallet);
        }
    }

}
