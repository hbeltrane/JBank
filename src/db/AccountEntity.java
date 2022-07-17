package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Account;
import entity.Customer;
import entity.Movement;
import entity.Return;

public class AccountEntity {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static void viewAccount(Account inAccount, ArrayList<Movement> accountMovements, Return result) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
            		+ "SELECT movements.*, transactions.transaction_desc "
            		+ "FROM movements "
            		+ "JOIN transactions "
            		+ "ON movements.transaction_id = transactions.transaction_id "
            		+ "WHERE movements.source_account = ? "
            		+ "OR movements.destination_account = ? "
            		+ "ORDER BY movement_date DESC");
            statement.setString(1, inAccount.getAccNumber());
            statement.setString(2, inAccount.getAccNumber());
            System.out.println("\nQuerying movements table\n");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	Movement queryResult = new Movement(resultSet.getInt("movement_id"), resultSet.getString("source_account"), resultSet.getString("destination_account"), resultSet.getDouble("amount"), resultSet.getDouble("prev_balance"), resultSet.getDouble("new_balance"), resultSet.getDate("movement_date"), resultSet.getString("transaction_desc"));
            	accountMovements.add(queryResult);
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
