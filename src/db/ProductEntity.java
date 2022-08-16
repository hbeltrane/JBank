package db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Product;
import entity.Return;
/**
 * 
 * DB interactions to movements table
 *
 */
public class ProductEntity {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

/**
 * Selects product types
 * @param productsType
 * @param result
 */
    public static void viewProductsType(ArrayList<String> productsType, Return result) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
                    + "SELECT product_type "
                    + "FROM products"
                    + "ORDER BY product_id");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String queryResult = resultSet.getString("product_type");
                productsType.add(queryResult);
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
 * Selects products parameters
 * @param products
 * @param result
 */
    public static void viewProductsDetail(ArrayList<Product> products, Return result) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
                    + "SELECT * "
                    + "FROM products "
                    + "ORDER BY product_id");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product queryResult = new Product(
                		resultSet.getInt("product_id"),
                        resultSet.getString("product_type"),
                        resultSet.getDouble("interest_rate"),
                        resultSet.getDouble("amount_limit"),
                        resultSet.getInt("quantity_limit"),
                        resultSet.getDouble("minimum_balance")
                );
                products.add(queryResult);
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
