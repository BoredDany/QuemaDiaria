module ing.soft.quemadiariaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.mail;


    opens ing.soft.quemadiariaproject to javafx.fxml;
    opens ing.soft.quemadiariaproject.Model.Domain.Entities to com.google.gson;
    exports ing.soft.quemadiariaproject;
    exports ing.soft.quemadiariaproject.Controller;
    opens ing.soft.quemadiariaproject.Controller to javafx.fxml;
}