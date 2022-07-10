package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Account;
import entity.Customer;

public class CustomerEntity {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static void viewCustomer(Customer inCustomer, ArrayList<Account> customerAccounts) {
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
            	Account result = new Account(resultSet.getString("acc_number"), resultSet.getString("product_type"), resultSet.getDouble("balance"), resultSet.getDouble("transfer_amount"), resultSet.getInt("transfer_quantity"), resultSet.getInt("customer_id"), resultSet.getDate("open_date"));
            	customerAccounts.add(result);
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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
