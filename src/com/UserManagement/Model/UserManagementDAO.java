package com.UserManagement.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.UserManagement.Bean.UserManagementBean;
import com.UserManagement.Connection.DBConnectionProvider;

public class UserManagementDAO {

	private static final String ADD_USERS = "insert into users_manage" + "(name,email,countries,userid)"
			+ "values(?,?,?,?)";

	private static final String LISTS_USERS = "select * from users_manage where userid=?";

	private static final String SELECT_BY_ID = "select * from users_manage where id=?";

	private static final String UPDATE_USERS = "update users_manage set name=?,email=?,countries=? where id=?";

	private static final String DELETE_USERS = "delete from users_manage where id=?";

	public boolean addUsers(UserManagementBean users) {
		boolean addUsersFlag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedStatement = connection.prepareStatement(ADD_USERS);
			System.out.println("INSERTED QUERY FOR USERS:- " + preparedStatement);

			preparedStatement.setString(1, users.getName());
			preparedStatement.setString(2, users.getEmail());
			preparedStatement.setString(3, users.getCountries());
			preparedStatement.setInt(4, users.getUserId());

			int addedUsers = preparedStatement.executeUpdate();

			if (addedUsers < 0 || addedUsers != 0) {
				addUsersFlag = true;
				System.out.println("Users added successfully:- " + addedUsers);
			} else if (addedUsers > 0 || addedUsers == 1) {
				addUsersFlag = true;
				System.out.println("Users added successfully:- " + addedUsers);
			} else {
				System.out.println("Something went wrong.Please try again...");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return addUsersFlag;
	}

	public List<UserManagementBean> getAllUsers(int uid) {

		List<UserManagementBean> lists = new ArrayList<UserManagementBean>();
		UserManagementBean users = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedStatement = connection.prepareStatement(LISTS_USERS);
			System.out.println("LISTING THE QUERY FOR USERS:- " + preparedStatement);

			preparedStatement.setInt(1, uid);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				users = new UserManagementBean();
				users.setId(resultSet.getInt(1));
				users.setName(resultSet.getString(2));
				users.setEmail(resultSet.getString(3));
				users.setCountries(resultSet.getString(4));
				users.setUserId(resultSet.getInt(5));
				lists.add(users);
			}

		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return lists;
	}

	public UserManagementBean getUsersById(int userid) {

		UserManagementBean users = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_BY_ID);
			System.out.println("GETTING THE QUERY FOR USERS USING ID:- " + preparedStatement);

			preparedStatement.setInt(1, userid);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				users = new UserManagementBean();
				users.setId(resultSet.getInt(1));
				users.setName(resultSet.getString(2));
				users.setEmail(resultSet.getString(3));
				users.setCountries(resultSet.getString(4));
				users.setUserId(resultSet.getInt(5));

			}

		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return users;
	}

	public boolean updateUsers(UserManagementBean users) {
		boolean updateUsersFlag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_USERS);
			System.out.println("UPDATED QUERY FOR USERS:- " + preparedStatement);

			preparedStatement.setString(1, users.getName());
			preparedStatement.setString(2, users.getEmail());
			preparedStatement.setString(3, users.getCountries());
			preparedStatement.setInt(4, users.getId());

			int updatedUsers = preparedStatement.executeUpdate();

			if (updatedUsers < 0 || updatedUsers != 0) {
				updateUsersFlag = true;
				System.out.println("Users updated successfully:- " + updatedUsers);
			} else if (updatedUsers > 0 || updatedUsers == 1) {
				updateUsersFlag = true;
				System.out.println("Users updated successfully:- " + updatedUsers);
			} else {
				System.out.println("Something went wrong.Please try again...");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return updateUsersFlag;
	}

	public boolean deleteUsers(int uid) {
		boolean deleteUsersFlag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_USERS);
			System.out.println("DELETED QUERY FOR USERS:- " + preparedStatement);

			preparedStatement.setInt(1, uid);

			int deletedUsers = preparedStatement.executeUpdate();

			if (deletedUsers < 0 || deletedUsers != 0) {
				deleteUsersFlag = true;
				System.out.println("Users deleted successfully:- " + deletedUsers);
			} else if (deletedUsers > 0 || deletedUsers == 1) {
				deleteUsersFlag = true;
				System.out.println("Users deleted successfully:- " + deletedUsers);
			} else {
				System.out.println("Something went wrong.Please try again...");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return deleteUsersFlag;
	}
}
