package ing.soft.quemadiariaproject.Model.Domain.Exceptions;

public class WalletException extends Exception {
    public WalletException() {
        super();
    }

    public WalletException(String message) {
        super(message);
    }

    public WalletException(String message, Throwable cause) {
        super(message, cause);
    }
}
