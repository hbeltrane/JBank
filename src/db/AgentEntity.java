package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class AgentEntity {

    // Defining JDBC objects
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static void validateAgent() {
        try {
            // Connect to the database
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();

            // Execute a SELECT statement
            statement = connection.prepareStatement("SELECT customer_id, first_name, last_name  \n" +
                    "FROM customers WHERE agent_id = ?");
            statement.setString(1, "jmisk5");

            resultSet = statement.executeQuery();

            // Display the results of a SELECT statement
            System.out.println("Bank Customers created by Jonie Misk:\n");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("customer_id") + " " +
                        resultSet.getString("first_name") + " " +
                        resultSet.getString("last_name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
