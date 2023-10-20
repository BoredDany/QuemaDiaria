package ing.soft.quemadiariaproject.Controller;

import javafx.scene.control.Label;

public class ErrorController {
    public Label messageLabel;
    public ErrorController (String messageLabel){
        this.messageLabel.setText(messageLabel);
    }
}
