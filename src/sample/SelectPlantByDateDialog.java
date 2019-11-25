package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SelectPlantByDateDialog {
    Stage stage = new Stage();

    public SelectPlantByDateDialog() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("SelectPlantByDateMenu.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Режимы полива растений");


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void showDialog(){
        stage.show();
    }


}