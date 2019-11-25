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

public class ParkZoneDialogController implements Initializable {
    @FXML
    private TextField id;
    @FXML
    private TextField zone;
    @FXML
    private TextField park;
    private ObservableList<Data> usersData = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Data, String> col2;
    @FXML
    private TableColumn<Data, Integer> col1;
    @FXML
    private TableColumn<Data, Integer> col3;
    @FXML
    private TableView<Data> table;
    private Connection conn = Main.returnCon();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTable();
    }

    private void createTable(){
        usersData.clear();
        col1.setCellValueFactory(new PropertyValueFactory<Data, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<Data, String>("park"));
        col3.setCellValueFactory(new PropertyValueFactory<Data, Integer>("zone"));

        try(PreparedStatement preparedStatement=conn.prepareStatement("select * from zone_park");
            ResultSet rs= preparedStatement.executeQuery();) {
            while (rs.next()) {
                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3));
                usersData.add(new Data(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
            table.setItems(usersData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void delete(ActionEvent actionEvent) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM zone_park CASCADE WHERE id=?");
        preparedStatement.setInt(1, Integer.parseInt(id.getText()));
        preparedStatement.executeUpdate();
        createTable();
    }

    @FXML
    public void saveTable(ActionEvent actionEvent) {

        try(PreparedStatement preparedStatement=preparedStatementSave();){
            preparedStatement.executeUpdate();
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement preparedStatementSave() throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO zone_park (park, zone) VALUES (?,?)");
        preparedStatement.setString(1,park.getText());
        preparedStatement.setInt(2, Integer.parseInt(zone.getText()));
        return preparedStatement;
    }
}
