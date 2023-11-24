package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Controller.CentralController;
import ing.soft.quemadiariaproject.Model.DTOs.WalletDTO;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.WalletException;
import ing.soft.quemadiariaproject.Model.Persistence.Files.FilePersistenceWallet;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceWallet;
import ing.soft.quemadiariaproject.Model.UseCases.WalletManagement;

public class WalletService implements WalletFacade {
    private PersistenceWallet persistence = new FilePersistenceWallet();
    private WalletManagement walletManagement = new WalletManagement(persistence);
    @Override
    public void saveWallet(WalletDTO wallet) throws WalletException {
        walletManagement.addWallet(wallet);
    }

    @Override
    public void getWallet(String username) {
        WalletDTO walletDTO = persistence.consult(username);
        CentralController.setWalletDTO(walletDTO);
    }
}
