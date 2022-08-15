package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Account;
import entity.Agent;
import entity.Customer;
import entity.Return;

/**
 * 
 * DB interactions to customers table
 *
 */
public class CustomerEntity {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

/**
 * Selects active accounts for a customer
 * @param activeCustomer
 * @param customerAccounts
 * @param result
 */
    public static void viewCustomer(Customer activeCustomer, ArrayList<Account> customerAccounts, Return result) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
            		+ "SELECT accounts.*, products.product_type "
            		+ "FROM accounts "
            		+ "JOIN products "
            		+ "ON accounts.acc_type = products.product_id "
            		+ "WHERE accounts.customer_id = ?");
            statement.setInt(1, activeCustomer.getCustomerId());
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

/**
 * Selects a customer by ID
 * @param activeCustomer
 * @param customerId
 * @param result
 */
    public static void getCustomerById(Customer activeCustomer, int customerId, Return result) {
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
            	activeCustomer.setCustomerId(resultSet.getInt("customer_id"));
            	activeCustomer.setPin(resultSet.getString("pin"));
            	activeCustomer.setFirstName(resultSet.getString("first_name"));
            	activeCustomer.setLastName(resultSet.getString("last_name"));
            	activeCustomer.setAddress(resultSet.getString("address"));
            	activeCustomer.setPhoneNumber(resultSet.getString("phone_number"));
            	activeCustomer.setEmail(resultSet.getString("email"));
            	activeCustomer.setCreationDate(resultSet.getDate("creation_date"));
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

/**
 * Updates customer information
 * @param activeCustomer
 * @param result
 */
    public static void updateCustomer(Customer activeCustomer, Return result) {
    	try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
            		+ "UPDATE customers SET "
            		+ "pin = ?, "
            		+ "first_name = ?, "
            		+ "last_name = ?, "
            		+ "address = ?, "
            		+ "phone_number = ? "
            		+ "WHERE customer_id = ? ");
            statement.setString(1, activeCustomer.getPin());
            statement.setString(2, activeCustomer.getFirstName());
            statement.setString(3, activeCustomer.getLastName());
            statement.setString(4, activeCustomer.getAddress());
            statement.setString(5, activeCustomer.getPhoneNumber());
            statement.setInt(6, activeCustomer.getCustomerId());
            System.out.println("\nUpdating customers table\n");
            statement.executeUpdate();
        	result.setCode("00");
        } catch (SQLException | NullPointerException ex) {
        	if (((SQLException)ex).getErrorCode() == 1) {
                result.setCode("03");
        	}
        	else {
                System.out.println(ex.getMessage());
                result.setCode("99");
        	}
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
/**
 * Deletes a customer
 * @param activeCustomer
 * @param activeAgent
 * @param result
 */
    public static void deleteCustomer(Customer activeCustomer, Agent activeAgent, Return result) {
    	try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
            		+ "INSERT INTO customers_hist "
            		+ "(customer_id, first_name, last_name, creation_date, delete_date, agent_id) " 
            		+ "VALUES "
            		+ "(?, ?, ?, ?, SYSDATE, ?)");
            statement.setInt(1, activeCustomer.getCustomerId());
            statement.setString(2, activeCustomer.getFirstName());
            statement.setString(3, activeCustomer.getLastName());
            statement.setDate(4,  (Date)activeCustomer.getCreationDate());
            statement.setString(5, activeAgent.getUsername());
            System.out.println("\nInserting into customers_hist table\n");
            statement.executeUpdate();
            statement = connection.prepareStatement(""
            		+ "DELETE FROM customers "
            		+ "WHERE customer_id = ? ");
            statement.setInt(1, activeCustomer.getCustomerId());
            System.out.println("\nDeleting from customers table\n");
            statement.executeUpdate();
        	result.setCode("00");
        } catch (SQLException | NullPointerException ex) {
        	System.out.println(ex.getMessage());
        	result.setCode("99");
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
