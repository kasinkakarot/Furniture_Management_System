package furniture_management;

import furniture_management.Controller.DataProcessingViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitchHelper {

    public static void switchScene(
            Stage currentStage,
            String fxmlFileName,
            String title) {

        try {

            FXMLLoader fxmlLoader =
                    new FXMLLoader(
                            SceneSwitchHelper.class.getResource(fxmlFileName)
                    );

            Scene scene = new Scene(fxmlLoader.load());

            currentStage.setTitle(title);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}