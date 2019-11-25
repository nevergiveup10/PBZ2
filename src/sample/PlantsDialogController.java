package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PlantsDialogController implements Initializable {
    private int currentParkId;
    private int currentZoneNumber;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private String currentDate;
    @FXML
    private TextField type;
    @FXML
    private DatePicker plantDate;
    @FXML
    private TextField age;
    @FXML
    private ChoiceBox<Integer> parkId;
    @FXML
    private ChoiceBox<Integer> zone;
    @FXML
    private TextField idDel;

    private ObservableList<Data> usersData = FXCollections.observableArrayList();
    private ObservableList<Integer> parkIDList = FXCollections.observableArrayList();
    private ObservableList<Integer> zoneList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Data, Integer> col1;
    @FXML
    private TableColumn<Data, String> col2;
    @FXML
    private TableColumn<Data, String> col3;
    @FXML
    private TableColumn<Data, Integer> col4;
    @FXML
    private TableColumn<Data, Integer> col5;
    @FXML
    private TableColumn<Data, Integer> col6;
    @FXML
    private TableView<Data> table;
    private Connection conn = Main.returnCon();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTable();
        parkId.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                try {
                    setNumberOfZones();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void createTable() {
        usersData.clear();
        parkIDList.clear();
        col1.setCellValueFactory(new PropertyValueFactory<Data, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<Data, String>("type"));
        col3.setCellValueFactory(new PropertyValueFactory<Data, String>("plantDate"));
        col4.setCellValueFactory(new PropertyValueFactory<Data, Integer>("age"));
        col5.setCellValueFactory(new PropertyValueFactory<Data, Integer>("parkId"));
        col6.setCellValueFactory(new PropertyValueFactory<Data, Integer>("zone"));

        try (PreparedStatement preparedStatement = conn.prepareStatement("select id from zone_park");
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                parkIDList.add(rs.getInt(1));
            }
            parkId.getItems().addAll(parkIDList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = conn.prepareStatement("select * from plants");
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getInt(4) + rs.getInt(5) + rs.getInt(6));
                usersData.add(new Data(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
            table.setItems(usersData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void delete(ActionEvent actionEvent) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM plants CASCADE WHERE id=?");
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
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO plants (type, plant_date, age, park_id, zone) VALUES (?,?,?,?,?)");
        currentDate = formatter.format(plantDate.getValue());
        preparedStatement.setString(1, type.getText());
        preparedStatement.setString(2, currentDate);
        preparedStatement.setInt(3, Integer.parseInt(age.getText()));
        preparedStatement.setInt(4, Integer.parseInt(parkId.getValue().toString()));
        preparedStatement.setInt(5, Integer.parseInt(zone.getValue().toString()));
        return preparedStatement;
    }

       public void setNumberOfZones() throws SQLException {
           zoneList.clear();
           zone.getItems().clear();
        currentParkId = parkId.getValue();
            currentZoneNumber=0;
           PreparedStatement preparedStatement=conn.prepareStatement("select zone from zone_park WHERE id=?");
               preparedStatement.setInt(1, currentParkId);
            ResultSet rs= preparedStatement.executeQuery(); {
                while (rs.next()) {
                currentZoneNumber = rs.getInt(1);
                for(int i=1; i<=currentZoneNumber; i++) {
                    zoneList.add(i);
                }
                zone.getItems().addAll(zoneList);
            }
        }
        }
    }
