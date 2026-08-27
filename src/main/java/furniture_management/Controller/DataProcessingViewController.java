package furniture_management.Controller;

import furniture_management.Furniture;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataProcessingViewController
{
    @javafx.fxml.FXML
    private TableColumn<Furniture,Double> priceTC;
    @javafx.fxml.FXML
    private TableColumn<Furniture,Double> discountTC;
    @javafx.fxml.FXML
    private TextField minimumPriceTF;
    @javafx.fxml.FXML
    private TableView<Furniture> DataProcessingTV;
    @javafx.fxml.FXML
    private TableColumn<Furniture, Double> vatTC;
    @javafx.fxml.FXML
    private TableColumn<Furniture, String> typeTC;
    @javafx.fxml.FXML
    private TableColumn<Furniture, Boolean> importedTC;
    @javafx.fxml.FXML
    private CheckBox onlyImportedCB;
    @javafx.fxml.FXML
    private TableColumn<Furniture,String> IDTC;
    @javafx.fxml.FXML
    private ComboBox<String> furnitureTypeCB;
    @javafx.fxml.FXML
    private TableColumn<Furniture,String> descriptionTC;

    @javafx.fxml.FXML
    public void initialize() {

        furnitureTypeCB.getItems().addAll(
                "All",
                "Chair",
                "Table",
                "Sofa",
                "Bed",
                "Cabinet"
        );

        IDTC.setCellValueFactory(
                new PropertyValueFactory<>("ID")
        );
        descriptionTC.setCellValueFactory(
                new PropertyValueFactory<>("Description")
        );
        typeTC.setCellValueFactory(
                new PropertyValueFactory<>("Type")
        );
        priceTC.setCellValueFactory(
                new PropertyValueFactory<>("Price")
        );
        discountTC.setCellValueFactory(
                new PropertyValueFactory<>("Discount")
        );
        vatTC.setCellValueFactory(
                new PropertyValueFactory<>("Vat")
        );
        importedTC.setCellValueFactory(
                new PropertyValueFactory<>("Imported")
        );
    }

    @javafx.fxml.FXML
    public void loadTableButtonOA(ActionEvent actionEvent) {
    }
}