package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class SelectEmployeesOrDecoratorsByDateDialogController implements Initializable {
    private int currentParkId;
    private int currentZoneNumber;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
    private String currentDate;
    @FXML
    private DatePicker plantDate;

    private ObservableList<Data> usersData = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Data, String> col1;
    @FXML
    private TableColumn<Data, String> col2;
    @FXML
    private TableColumn<Data, String> col3;
    @FXML
    private TableColumn<Data, String> col4;


    @FXML
    private TableView<Data> table;
    private Connection conn = Main.returnCon();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTable();
    }

    private void createTable() {
        usersData.clear();
        col1.setCellValueFactory(new PropertyValueFactory<Data, String>("status"));
        col2.setCellValueFactory(new PropertyValueFactory<Data, String>("fullName"));
        col3.setCellValueFactory(new PropertyValueFactory<Data, String>("address"));
        col4.setCellValueFactory(new PropertyValueFactory<Data, String>("number"));


    }


    public void getEmployeesByDate() throws SQLException {

        System.out.println( currentDate = formatter.format(plantDate.getValue()));
        currentDate = formatter.format(plantDate.getValue());
        currentDate = '%' + currentDate + '%';
        usersData.clear();
        getEmployees();
        getDecorators();
     table.setItems(usersData);
    }

    private void getEmployees() throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("select full_name, address, number from employees WHERE schedule like  ?");
        preparedStatement.setString(1, currentDate);
        ResultSet rs = preparedStatement.executeQuery();
        {
            while (rs.next()) {
             //   System.out.println(status1+rs.getString(1)+rs.getString(2)+rs.getString(3));
               usersData.add(new Data("Служитель", rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        }
    }

    private void getDecorators() throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement ("select full_name, address, number from decorators WHERE schedule like ?");
        preparedStatement.setString(1, currentDate);
        ResultSet rs = preparedStatement.executeQuery();
        {
            while (rs.next()) {
                usersData.add(new Data("Декоратор", rs.getString(1), rs.getString(2), rs.getString(3)));
            }

        }
    }
}
