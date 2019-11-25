package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeesDialog {
        Stage stage = new Stage();

        public EmployeesDialog() {

            try {

                Parent root = FXMLLoader.load(getClass().getResource("EmployeesMenu.fxml"));
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.setTitle("Управление инф. о работниках парка");


            } catch(Exception e) {
                e.printStackTrace();
            }

        }

        public void showDialog(){
            stage.show();
        }


    }
