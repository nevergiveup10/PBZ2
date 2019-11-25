package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SelectEmployeesOrDecoratorsByDateDialog {
    Stage stage = new Stage();

    public SelectEmployeesOrDecoratorsByDateDialog() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("SelectEmployeesOrDecoratorsByDateMenu.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Найти информацию о сотрудниках");


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void showDialog(){
        stage.show();
    }


}