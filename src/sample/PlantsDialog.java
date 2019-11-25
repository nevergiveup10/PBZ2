package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlantsDialog {
    Stage stage = new Stage();

    public PlantsDialog() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("PlantsMenu.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Управление инф. о растениях");


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void showDialog(){
        stage.show();
    }


}
