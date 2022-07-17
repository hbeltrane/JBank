package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Account;
import entity.Customer;
import entity.Return;

public class CustomerEntity {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static void viewCustomer(Customer inCustomer, ArrayList<Account> customerAccounts, Return result) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
            		+ "SELECT accounts.*, products.product_type "
            		+ "FROM accounts "
            		+ "JOIN products "
            		+ "ON accounts.acc_type = products.product_id "
            		+ "WHERE accounts.customer_id = ?");
            statement.setInt(1, inCustomer.getCustomerId());
            System.out.println("\nQuerying accounts table\n");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	Account queryResult = new Account(resultSet.getString("acc_number"), resultSet.getString("product_type"), resultSet.getDouble("balance"), resultSet.getDouble("transfer_amount"), resultSet.getInt("transfer_quantity"), resultSet.getInt("customer_id"), resultSet.getDate("open_date"));
            	customerAccounts.add(queryResult);
            }
            result.setCode("00");
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
            result.setCode("99");
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void getCustomerById(Customer inCustomer, int customerId, Return result) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
            		+ "SELECT * "
            		+ "FROM customers "
            		+ "WHERE customer_id = ?");
            statement.setInt(1, customerId);
            System.out.println("\nQuerying customers table\n");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	inCustomer.setCustomerId(resultSet.getInt("customer_id"));
            	inCustomer.setPin(resultSet.getString("pin"));
            	inCustomer.setFirstName(resultSet.getString("first_name"));
            	inCustomer.setLastName(resultSet.getString("last_name"));
            	inCustomer.setAddress(resultSet.getString("address"));
            	inCustomer.setPhoneNumber(resultSet.getString("phone_number"));
            	inCustomer.setEmail(resultSet.getString("email"));
            	inCustomer.setCreationDate(resultSet.getDate("creation_date"));
            }
            result.setCode("00");
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
            result.setCode("99");
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
