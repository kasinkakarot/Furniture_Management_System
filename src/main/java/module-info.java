module cse213.furniture_management {
    requires javafx.controls;
    requires javafx.fxml;


    opens furniture_management to javafx.fxml;
    exports furniture_management;
}