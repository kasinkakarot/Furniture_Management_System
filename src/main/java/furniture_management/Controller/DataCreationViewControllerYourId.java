package furniture_management.Controller;

import furniture_management.BinaryFileUtility;
import furniture_management.Furniture;
import furniture_management.SceneSwitchHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class DataCreationViewControllerYourId {
    @javafx.fxml.FXML
    private TextField discountPercentageTF;
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private TextField vatPercantageTF;
    @javafx.fxml.FXML
    private TextField furnitureIDTF;
    @javafx.fxml.FXML
    private TextField furnitureDescripTF;
    @javafx.fxml.FXML
    private ComboBox<String> furnitureTypeCB;
    @javafx.fxml.FXML
    private CheckBox isImportedCB;

    @javafx.fxml.FXML
    public void initialize() {

        furnitureTypeCB.getItems().addAll(
                "Chair",
                "Table",
                "Sofa",
                "Bed",
                "Cabinet"
        );
    }

    @javafx.fxml.FXML
    public void goToDataButtonOA(ActionEvent actionEvent) {

        Stage currentStage =
                (Stage) ((javafx.scene.Node)actionEvent.getSource())
                        .getScene()
                        .getWindow();
        SceneSwitchHelper.switchScene(
                currentStage,
                "DataProcessingView.fxml",
                "Data Processing View"
        );
    }

    @javafx.fxml.FXML
    public void validateAndAddButtonOA(ActionEvent actionEvent) {
        if (furnitureIDTF.getText().isEmpty()
                || furnitureDescripTF.getText().isEmpty()
                || furnitureTypeCB.getValue() == null
                || vatPercantageTF.getText().isEmpty()
                || priceTF.getText().isEmpty()
                || discountPercentageTF.getText().isEmpty()) {
            return;
        }

        try {
            double price = Double.parseDouble(priceTF.getText());
            double vat = Double.parseDouble(vatPercantageTF.getText());
            double discountPercentage = Double.parseDouble(discountPercentageTF.getText());

            if (price < 0 || vat < 0 || discountPercentage < 0) {
                return;
            }

            String ID = furnitureIDTF.getText();
            String Description = furnitureDescripTF.getText();
            boolean isImported = isImportedCB.isSelected();
            String Type = furnitureTypeCB.getValue().toString();

            Furniture furniture = new Furniture(
                    ID,
                    Description,
                    Type,
                    price,
                    discountPercentage,
                    vat,
                    isImported
            );
            BinaryFileUtility.writeFurniture(furniture);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Furniture has been added successfully");
            alert.showAndWait();

        } catch (NumberFormatException e) {
            return;
        }
    }
}