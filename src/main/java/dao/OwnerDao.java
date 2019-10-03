package dao;

import java.sql.*;

import database.DatabaseManager;
import models.Owner;

public class OwnerDao {
	public OwnerDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertOwner(Owner owner) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO owner (firstName,lastName,email,phoneNumber,password) VALUES(?,?,?,?,?)";
			PreparedStatement myPreparedStatement = connection.prepareStatement(query);
			myPreparedStatement.setString(1, owner.getFirstName());
			myPreparedStatement.setString(2, owner.getLastName());
			myPreparedStatement.setString(3, owner.getEmail());
			myPreparedStatement.setString(4, owner.getPhoneNumber());
			myPreparedStatement.setString(5, owner.getPassword());
			res = myPreparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return res;
	}
	public Owner getOwner(Owner owner) {
		Connection connection = DatabaseManager.GetConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM owner WHERE email = '"+owner.getEmail()+"'";
			ResultSet res = statement.executeQuery(query);
			if(res.next()) {
				Owner aOwner = new Owner(Integer.parseInt(res.getString("ownerId")),res.getString("email"), res.getString("phoneNumber"), res.getString("password"),res.getString("firstName"),res.getString("lastName"));
				return aOwner;
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

}
