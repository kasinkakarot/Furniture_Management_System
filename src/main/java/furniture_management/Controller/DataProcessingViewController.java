package furniture_management.Controller;

import furniture_management.BinaryFileUtility;
import furniture_management.Furniture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class DataProcessingViewController {

    @FXML
    private TableColumn<Furniture, Double> priceTC;

    @FXML
    private TableColumn<Furniture, Double> discountTC;

    @FXML
    private TextField minimumPriceTF;

    @FXML
    private TableView<Furniture> DataProcessingTV;

    @FXML
    private TableColumn<Furniture, Double> vatTC;

    @FXML
    private TableColumn<Furniture, String> typeTC;

    @FXML
    private TableColumn<Furniture, Boolean> importedTC;

    @FXML
    private CheckBox onlyImportedCB;

    @FXML
    private TableColumn<Furniture, String> IDTC;

    @FXML
    private ComboBox<String> furnitureTypeCB;

    @FXML
    private TableColumn<Furniture, String> descriptionTC;


    @FXML
    public void initialize() {

        furnitureTypeCB.getItems().addAll(
                "All",
                "Chair",
                "Table",
                "Sofa",
                "Bed",
                "Cabinet"
        );

        furnitureTypeCB.setValue("All");

        IDTC.setCellValueFactory(
                new PropertyValueFactory<>("ID")
        );

        descriptionTC.setCellValueFactory(
                new PropertyValueFactory<>("description")
        );

        typeTC.setCellValueFactory(
                new PropertyValueFactory<>("type")
        );

        priceTC.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );

        discountTC.setCellValueFactory(
                new PropertyValueFactory<>("discountPrice")
        );

        vatTC.setCellValueFactory(
                new PropertyValueFactory<>("vatPercentage")
        );

        importedTC.setCellValueFactory(
                new PropertyValueFactory<>("imported")
        );
    }


    @FXML
    public void loadTableButtonOA(ActionEvent actionEvent) {

        ArrayList<Furniture> furnitureList =
                BinaryFileUtility.readAllFurniture();

        DataProcessingTV.getItems().clear();

        double minimumPrice = 0;

        if (!minimumPriceTF.getText().isEmpty()) {

            try {

                minimumPrice =
                        Double.parseDouble(minimumPriceTF.getText());

            } catch (NumberFormatException e) {

                showError("Minimum price must be a valid number.");
                return;
            }
        }


        String selectedType = furnitureTypeCB.getValue();

        boolean onlyImported =
                onlyImportedCB.isSelected();


        for (Furniture furniture : furnitureList) {

            // Minimum price filter
            if (furniture.getPrice() < minimumPrice) {
                continue;
            }

            // Furniture type filter
            if (selectedType != null
                    && !selectedType.equals("All")
                    && !furniture.getType().equals(selectedType)) {

                continue;
            }

            // Imported filter
            if (onlyImported && !furniture.isImported()) {
                continue;
            }

            DataProcessingTV.getItems().add(furniture);
        }
    }


    private void showError(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}