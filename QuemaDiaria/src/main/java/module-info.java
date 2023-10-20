module ing.soft.quemadiaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens ing.soft.quemadiaria to javafx.fxml;
    opens ing.soft.quemadiaria.Model.Domain.Entities to com.google.gson;
    exports ing.soft.quemadiaria;
    exports ing.soft.quemadiaria.Controller;

}