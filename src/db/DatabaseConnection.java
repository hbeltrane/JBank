package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * DB connection handling
 *
 */
public class DatabaseConnection {
    // Private instance, so that it can be accessed by only by getInstance() method
    private static DatabaseConnection connectionManager = null;
    private Connection connection = null;
    //String url = "jdbc:oracle:thin:@//localhost:1521/xe";
    String url = "jdbc:oracle:thin:@//localhost:1521/ORCLCDB";
    String username = "jbank";
    String password = "Lambton2022S";
    // private constructor
    private DatabaseConnection() {
        System.out.println("Connecting database...");

        try {
            // Connect to the database
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Database Connection Creation Failed : " +  ex);
        }
    }

    // Returns a Connection instance
    public Connection getConnection() {
        return connection;
    }

    // Method to return instance of DatabaseConnection class
    public static DatabaseConnection getInstance() throws SQLException  {
        if (connectionManager == null)
        {
            // if instance is null, initialize
            connectionManager = new DatabaseConnection();
        }
        return connectionManager;
    }
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
