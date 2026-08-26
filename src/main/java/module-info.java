module furniture_management {
    requires javafx.controls;
    requires javafx.fxml;

    opens furniture_management to javafx.fxml;
    opens furniture_management.Controller to javafx.fxml;

    exports furniture_management;
}