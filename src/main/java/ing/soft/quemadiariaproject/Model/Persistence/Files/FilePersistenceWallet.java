package ing.soft.quemadiariaproject.Model.Persistence.Files;

import com.google.gson.*;
import ing.soft.quemadiariaproject.Model.DTOs.WalletDTO;
import ing.soft.quemadiariaproject.Model.Domain.Entities.Wallet;
import ing.soft.quemadiariaproject.Model.UseCases.Persistence.PersistenceWallet;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilePersistenceWallet implements PersistenceWallet {
    @Override
    public void saveWallet(Wallet wallet) {
        try {
            List<Wallet> walletList = consultWalletsList();
            System.out.println("Registering wallet: " + wallet);
            walletList.add(wallet);
            FileWriter fileWriter = new FileWriter("Wallets.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(walletList, fileWriter);
            fileWriter.close();
            System.out.println("Information successfully saved");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }

    @Override
    public List<Wallet> consultWalletsList() {
        Gson gson = new Gson();
        try {
            Path filePath = Path.of("Wallets.json");
            String content = Files.readString(filePath);
            List<Wallet> walletsList = new ArrayList<>();
            try {
                Wallet[] wallets = gson.fromJson(content, Wallet[].class);
                if(wallets == null)
                    return new ArrayList<>();
                return new ArrayList<>(List.of(wallets));
            } catch (JsonSyntaxException e) {
                if (e.getMessage().equals(
                        "Expected BEGIN_OBJECT but was BEGIN_ARRAY")) {
                    JsonArray jsonArray = new JsonParser()
                            .parse(content)
                            .getAsJsonArray();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Wallet certificate = gson.fromJson(jsonArray.get(i), Wallet.class);
                        walletsList.add(certificate);
                    }
                    return walletsList;
                } else {
                    // Handle other JSON parsing errors
                    e.printStackTrace();
                    throw new RuntimeException("Error managing the file", e);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }

    @Override
    public WalletDTO consult(String username) {
        for(Wallet w: consultWalletsList()){
            if(w.getTrainerUsername().equals(username)){
                WalletDTO walletDTO = new WalletDTO(username, w.getAccountNumber(), w.getBankName(),w.getAccountType());
                return walletDTO;
            }
        }
        return null;
    }

    @Override
    public boolean walletExists(WalletDTO walletDTO) {
        for(Wallet w: consultWalletsList()){
            if(!w.getTrainerUsername().equals(walletDTO.getTrainerUsername()) &&
                    w.getAccountNumber().equals(walletDTO.getAccountNumber()) &&
                    w.getBankName().equals(walletDTO.getBankName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateFile(List<Wallet> wallets) {
        try {
            //System.out.println("Saving trainers to file...");
            FileWriter fileWriter = new FileWriter("Wallets.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(wallets, fileWriter);
            fileWriter.close();
            //System.out.println("Trainers successfully saved to file");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error managing the file", e);
        }
    }
}
