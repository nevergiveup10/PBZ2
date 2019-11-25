package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Controller {
    private ImageView image1 = new ImageView();
    private ImageView image2 = new ImageView();


    @FXML
    private void click(ActionEvent event) {
        FirmsDialog firmsDialog = new FirmsDialog();
        firmsDialog.showDialog();
    }

    @FXML
    private void click2(ActionEvent event) {
        ParkZoneDialog parkZoneDialog = new ParkZoneDialog();
        parkZoneDialog.showDialog();
    }

    @FXML
    private void click3(ActionEvent event) {
        PlantsDialog plantsDialog = new PlantsDialog();
        plantsDialog.showDialog();
    }

    @FXML
    private void click4(ActionEvent event) {
        EmployeesDialog employeesDialog = new EmployeesDialog();
        employeesDialog.showDialog();
    }

    @FXML
    private void click5(ActionEvent event) {
        DecoratorsDialog decoratorsDialog = new DecoratorsDialog();
        decoratorsDialog.showDialog();
    }

    @FXML
    private void click6(ActionEvent event) {
            SelectPlantByNameDialog selectPlantByNameDialog = new SelectPlantByNameDialog();
            selectPlantByNameDialog.showDialog();
    }

    @FXML
    private void click7(ActionEvent event) {
        SelectEmployeesOrDecoratorsByDateDialog selectEmployeesOrDecoratorsByDateDialog = new SelectEmployeesOrDecoratorsByDateDialog();
        selectEmployeesOrDecoratorsByDateDialog.showDialog();
    }

    @FXML
    private void click8(ActionEvent event) {
       SelectPlantByDateDialog selectPlantByDateDialog = new SelectPlantByDateDialog();
        selectPlantByDateDialog.showDialog();
    }

    @FXML
    private void click9(ActionEvent event) {
        System.exit(0);
    }
}
