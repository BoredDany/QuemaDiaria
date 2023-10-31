package ing.soft.quemadiariaproject.Model.UseCases.Persistence;

import ing.soft.quemadiariaproject.Model.DTOs.WalletDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Wallet;

import java.util.List;

public interface PersistenceWallet {
    void saveWallet(Wallet wallet);
    List<Wallet> consultWalletsList();
    WalletDTO consult(String username);
}
