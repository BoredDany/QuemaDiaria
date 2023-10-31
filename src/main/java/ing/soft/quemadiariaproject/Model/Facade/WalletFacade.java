package ing.soft.quemadiariaproject.Model.Facade;

import ing.soft.quemadiariaproject.Model.DTOs.CertificateDTO;
import ing.soft.quemadiariaproject.Model.DTOs.WalletDTO;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.TrainerException;
import ing.soft.quemadiariaproject.Model.Domain.Exceptions.WalletException;

public interface WalletFacade {
    void saveWallet(WalletDTO wallet) throws WalletException;
    void getWallet(String username);
}
