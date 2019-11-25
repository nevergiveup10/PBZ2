package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DecoratorsDialog {
    Stage stage = new Stage();

    public DecoratorsDialog() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("DecoratorsMenu.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Управление инф. о декораторах");


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void showDialog(){
        stage.show();
    }


}
