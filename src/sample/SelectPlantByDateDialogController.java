package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class SelectPlantByDateDialogController implements Initializable {
    private int currentParkId;
    private int currentZoneNumber;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    //getTime() returns the current date in default time zone
    Date date = calendar.getTime();
    private String currentDate;
    @FXML
    private TextField type;

    private ObservableList<Data> usersData = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Data, Integer> col1;
    @FXML
    private TableColumn<Data, String> col2;
    @FXML
    private TableColumn<Data, Integer> col3;
    @FXML
    private TableColumn<Data, String> col4;
    @FXML
    private TableColumn<Data, String> col5;
    @FXML
    private TableColumn<Data, Integer> col6;

    @FXML
    private Label dateLabel;


    @FXML
    private TableView<Data> table;
    private Connection conn = Main.returnCon();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTable();
        dateLabel.setText(date.toString());
    }

    private void createTable() {
        usersData.clear();
        col1.setCellValueFactory(new PropertyValueFactory<Data, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<Data, String>("type"));
        col3.setCellValueFactory(new PropertyValueFactory<Data, Integer>("age"));
        col4.setCellValueFactory(new PropertyValueFactory<Data, String>("day"));
        col5.setCellValueFactory(new PropertyValueFactory<Data, String>("time"));
        col6.setCellValueFactory(new PropertyValueFactory<Data, Integer>("volume"));

    }


    public void getPlantsAndWateringPlan() throws SQLException {


        usersData.clear();


            PreparedStatement preparedStatement = conn.prepareStatement("select plants.id, plants.type, plants.age, wp.day, wp.time, wp.volume from plants inner join watering_plan wp on plants.type=wp.type where plants.age = wp.age and plants.type = ?");
            preparedStatement.setString(1, type.getText());
            ResultSet rs = preparedStatement.executeQuery();
            {
                while (rs.next()) {
                    usersData.add(new Data(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
                }
            }

        table.setItems(usersData);
    }

   }