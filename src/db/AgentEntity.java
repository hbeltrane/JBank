package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Account;
import entity.Agent;
import entity.Customer;

public class AgentEntity {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static int validateAgent(String inUsername, Agent activeAgent) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM agents WHERE username = ?");
            statement.setString(1, inUsername);
            resultSet = statement.executeQuery();
            System.out.println("Querying agents table\n");
            while (resultSet.next()) {
            	activeAgent.setUsername(resultSet.getString("username"));
            	activeAgent.setPassword(resultSet.getString("password"));
            	activeAgent.setFirstName(resultSet.getString("first_name"));
            	activeAgent.setLastName(resultSet.getString("last_name"));
            	activeAgent.setPositionId(resultSet.getInt("position_id"));
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
    
    public static void searchCustomers(String searchString, ArrayList<Customer> customersResult) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM customers WHERE first_name like %?% OR last_name like %?% OR address like %?% OR phone_number like %?% OR email like %?%");
            statement.setString(1, searchString);
            statement.setString(2, searchString);
            statement.setString(3, searchString);
            statement.setString(4, searchString);
            statement.setString(5, searchString);
            resultSet = statement.executeQuery();
            System.out.println("Querying customers table\n");
            while (resultSet.next()) {
            	Customer result = new Customer(resultSet.getInt("customer_id"), resultSet.getString("pin"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("address"), resultSet.getString("phone_number"), resultSet.getString("email"), resultSet.getDate("creation_date"));
            	customersResult.add(result);
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
    
    public static void searchAccounts(String searchString, ArrayList<Account> accountsResult) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM accounts WHERE acc_number like %?%");
            statement.setString(1, searchString);
            resultSet = statement.executeQuery();
            System.out.println("Querying accounts table\n");
            while (resultSet.next()) {
            	Account result = new Account(resultSet.getString("account_number"), resultSet.getInt("account_type"), resultSet.getDouble("balance"), resultSet.getDouble("transfer_amount"), resultSet.getInt("transfer_quantity"), resultSet.getInt("customer_id"), resultSet.getDate("open_date"));
            	accountsResult.add(result);
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
