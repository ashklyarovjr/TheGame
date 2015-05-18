package Helpers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
    public static Connection getConnection()  {


        ResourceBundle resourceBundle = ResourceBundle.getBundle("game");

        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String pass = resourceBundle.getString("db.password");

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {

            System.out.println("Impossible to connect to the DB!");
        }
        return connection;
    }


}
