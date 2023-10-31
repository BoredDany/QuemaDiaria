package ing.soft.quemadiariaproject.Model.Domain.Entities;

public class Wallet {
    private String trainerUsername;
    private String accountNumber;
    private String bankName;
    private String accountType;

    // Constructor
    public Wallet(String trainerUsername, String accountNumber, String bankName, String accountType) {
        this.trainerUsername = trainerUsername;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.accountType = accountType;
    }

    public String getTrainerUsername() {
        return this.trainerUsername;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setTrainerUsername(String nombreUsuario) {
    }

    public void setAccountNumber(String number) {
    }

    public void setBankName(String miBanco) {
    }

    public void setAccountType(String cuentaDeAhorros) {
    }
}
