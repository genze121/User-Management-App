package com.UserManagement.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.UserManagement.Bean.UserBean;
import com.UserManagement.Connection.DBConnectionProvider;

public class RegisterDAO {

	private static final String REGISTER_USER = "insert into user_" + "(firstname,lastname,username,password)"
			+ "values(?,?,?,?)";

	public boolean registerUser(UserBean user) {
		boolean registerFlag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedStatement = connection.prepareStatement(REGISTER_USER);
			System.out.println("QUERY:- " + preparedStatement);

			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());

			int registered = preparedStatement.executeUpdate();

			if (registered < 0 || registered != 0) {
				registerFlag = true;
				System.out.println("Registered Successfully:- " + registered);
			} else if (registered > 0 || registered == 1) {
				registerFlag = true;
				System.out.println("Registered Successfully:- " + registered);
			} else {
				System.out.println("Something went wrong.Please try again...");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return registerFlag;
	}

}
