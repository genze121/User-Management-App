package com.UserManagement.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

	private static final String URL = "jdbc:mysql://localhost:3306/User_Management";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private static String driver;
	static {
		try {
			driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public static Connection getConnection() {
		Connection connection = null;
		try {
			if (connection != null) {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connected Successfully!!!");
			} else if (connection == null) {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connected Successfully!!!");
			} else {
				System.out.println("Something went wrong in the server.Please try again...");
			}
		} catch (SQLException ex) {
			printSQLException(ex);
		}
		return connection;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQL State:- " + ((SQLException) e).getSQLState());
				System.err.println("Error Code:- " + ((SQLException) e).getErrorCode());
				System.err.println("Message:- " + ((SQLException) e).getMessage());
				Throwable thrown = ex.getCause();
				while (thrown != null) {
					thrown = thrown.getCause();
				}

			}
		}
	}

}
