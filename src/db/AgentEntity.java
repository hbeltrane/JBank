package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Agent;

import java.sql.PreparedStatement;

public class AgentEntity {

    // Defining JDBC objects
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static int validateAgent(String inUsername, Agent activeAgent) {
        try {
            // Connect to the database
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();

            // Execute a SELECT statement
            statement = connection.prepareStatement("SELECT * FROM agents WHERE username = ?");
            statement.setString(1, inUsername);

            resultSet = statement.executeQuery();

            // Display the results of a SELECT statement
            System.out.println("Querying agents table\n");
            while (resultSet.next()) {
            	activeAgent.setUsername(resultSet.getString("username"));
            	activeAgent.setPassword(resultSet.getString("password"));
            	activeAgent.setFirstName(resultSet.getString("first_name"));
            	activeAgent.setLastName(resultSet.getString("last_name"));
            	activeAgent.setPositionId(Integer.valueOf(resultSet.getString("position_id")));
            	return 0;
            }
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 99;
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
