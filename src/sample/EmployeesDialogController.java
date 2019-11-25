package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeesDialogController implements Initializable {
    @FXML
    private TextField idDel;
    @FXML
    private TextField fullName;
    @FXML
    private TextField number;
    @FXML
    private TextField address;
    @FXML
    private TextField schedule;

    private String scheduleStr;
    private String buff;

    private ObservableList<Data> usersData = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Data, Integer> col1;
    @FXML
    private TableColumn<Data, String> col2;
    @FXML
    private TableColumn<Data, String> col3;
    @FXML
    private TableColumn<Data, String> col4;
    @FXML
    private TableColumn<Data, String> col5;

    @FXML
    private TableView<Data> table;
    private Connection conn = Main.returnCon();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTable();

    }

    private void createTable() {
        usersData.clear();
        col1.setCellValueFactory(new PropertyValueFactory<Data, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<Data, String>("fullName"));
        col3.setCellValueFactory(new PropertyValueFactory<Data, String>("number"));
        col4.setCellValueFactory(new PropertyValueFactory<Data, String>("address"));
        col5.setCellValueFactory(new PropertyValueFactory<Data, String>("schedule"));


        try (PreparedStatement preparedStatement = conn.prepareStatement("select * from employees");
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5));
                scheduleStr = rs.getString(5);
                buff = Character.toString(scheduleStr.charAt(0));
                if (buff.equals("{")) {
                    scheduleStr = scheduleStr.substring(1, scheduleStr.length() - 1);
                }
                usersData.add(new Data(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), scheduleStr));
            }
            table.setItems(usersData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void delete(ActionEvent actionEvent) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM employees CASCADE WHERE id=?");
        preparedStatement.setInt(1, Integer.parseInt(idDel.getText()));
        preparedStatement.executeUpdate();
        createTable();
    }

    @FXML
    public void saveTable(ActionEvent actionEvent) {

        try (PreparedStatement preparedStatement = preparedStatementSave();) {
            preparedStatement.executeUpdate();
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement preparedStatementSave() throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO employees (full_name, number, address, schedule) VALUES (?,?,?,?)");
        preparedStatement.setString(1, fullName.getText());
        preparedStatement.setString(2, number.getText());
        preparedStatement.setString(3, address.getText());
        preparedStatement.setString(4, schedule.getText());
        return preparedStatement;
    }

}
