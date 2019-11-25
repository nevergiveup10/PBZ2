package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ParkZoneDialog {
    Stage stage = new Stage();
    public ParkZoneDialog() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("ParkZoneMenu.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Управление инф. о парках и зонах");


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void showDialog(){
        stage.show();
    }
}
