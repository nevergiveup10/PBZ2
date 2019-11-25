package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirmsDialog {
    Stage stage = new Stage();

    public FirmsDialog() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("FirmMenu.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Управление инф. о фирмах");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showDialog() {
        stage.show();
    }
    public void closeDialog() {
        stage.close();
    }
}
