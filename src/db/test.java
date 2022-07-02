package db;

import java.sql.*;

public class test {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			String dbUrl = "jdbc:oracle:thin:jbank/Lambton2022S@localhost:1521:xe";
			connection = DriverManager.getConnection(dbUrl);
			
			statement = connection.createStatement();
			String query = "SELECT * FROM customers ";
			result = statement.executeQuery(query);
			
			while (result.next()) {
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				System.out.println("Name: " + first_name + " " + last_name);
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			try {
				if (result != null) {
					result.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

}
