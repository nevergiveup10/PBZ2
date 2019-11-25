package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SelectPlantByNameDialog {

    Stage stage = new Stage();

    public SelectPlantByNameDialog() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("SelectPlantByNameMenu.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Найти информацию о насаждениях");


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void showDialog(){
        stage.show();
    }


}