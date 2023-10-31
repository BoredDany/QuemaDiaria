package ing.soft.quemadiariaproject.Model.DTOs;

public class WalletDTO {
    private String trainerUsername; // El entrenador asociado a esta cuenta bancaria
    private String accountNumber;
    private String bankName;
    private String accountType;

    public WalletDTO() {
    }

    public WalletDTO(String trainerUsername, String accountNumber, String bankName, String accountType) {
        this.trainerUsername = trainerUsername;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.accountType = accountType;
    }

    public String getTrainerUsername() {
        return trainerUsername;
    }

    public void setTrainerUsername(String trainerUsername) {
        this.trainerUsername = trainerUsername;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "WalletDTO{" +
                "trainerUsername='" + trainerUsername + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
