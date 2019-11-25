package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {
    private static Connection conn;
    public static Connection returnCon() {
        return conn;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Банк данных насаждений парков");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static Connection connect() throws SQLException {
        final String url = "jdbc:postgresql://localhost/pbz2";
        final String user = "postgres";
        final String password = "6001";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public static void main(String[] args) throws SQLException {
        connect();
        launch(args);
    }
}
