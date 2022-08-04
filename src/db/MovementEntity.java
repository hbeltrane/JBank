package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Account;
import entity.Agent;
import entity.Movement;
import entity.Return;

public class MovementEntity {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static double checkFee(int txId, Movement activeMovement, Return result) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
            		+ "SELECT * "
            		+ "FROM transaction "
            		+ "WHERE transaction_id = ? ");
            statement.setInt(1, txId);
            System.out.println("\nQuerying transactions table\n");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	activeMovement.setDescription(resultSet.getString("transaction_desc"));
            }
            result.setCode("00");
            double fee = resultSet.getDouble("fee");
            return fee;
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
            result.setCode("99");
            return 0;
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

    public static void createTransaction(int txId, Movement activeMovement, Agent activeAgent, Return result) {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getConnection();
            statement = connection.prepareStatement(""
            		+ "INSERT INTO movements "
            		+ "(movement_id, source_account, destination_account, amount, prev_balance, new_balance, creation_date, transaction_id, agent_id) "
            		+ "VALUES (DEFAULT, ?, ?, ?, ?, ?, SYSDATE, ?, ?) ");
            statement.setString(1, activeMovement.getSourceAccount());
            statement.setString(2, activeMovement.getDestinationAccount());
            statement.setDouble(3, activeMovement.getAmount());
            statement.setDouble(4, activeMovement.getPreviousBalance());
            statement.setDouble(5, activeMovement.getNewBalance());
            statement.setInt(6, txId);
            statement.setString(7, activeAgent.getUsername());
            System.out.println("\nInserting into movements table\n");
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
