package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DatabaseManager;
import models.House;
import models.Rent;

public class RentDao {
	public RentDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertRent(Rent aRent) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO rent (houseId,noOfRooms,extras,rentPerMonth,advance,photos,featuredPhotos,ispublished) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement myPreparedStatement = connection.prepareStatement(query);
			myPreparedStatement.setInt(1, aRent.getHouseId());
			myPreparedStatement.setString(2, aRent.getNoOfRooms());
			myPreparedStatement.setString(3, aRent.getExtras());
			myPreparedStatement.setString(4, aRent.getRentPerMonth());
			myPreparedStatement.setString(5, aRent.getAdvance());
			myPreparedStatement.setString(6, aRent.getPhotos());
			myPreparedStatement.setString(7, aRent.getFeaturedPhotos());
			myPreparedStatement.setBoolean(8, aRent.isIspublish());
		
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
	public ArrayList<Rent> getAllRents(int houseId){
		ArrayList<Rent> rents = new ArrayList<Rent>();
		Connection connection = DatabaseManager.GetConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM rent WHERE houseId ="+houseId;
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Rent aRent = new Rent();
				
				aRent.setRentId(resultSet.getInt("rentId"));
				aRent.setHouseId(resultSet.getInt("houseId"));
				aRent.setExtras(resultSet.getString("extras"));
				aRent.setNoOfRooms(resultSet.getString("noOfRooms"));
				aRent.setRentPerMonth(resultSet.getString("rentPerMonth"));
				aRent.setAdvance(resultSet.getString("advance"));
				aRent.setPhotos(resultSet.getString("photos"));
				aRent.setFeaturedPhotos(resultSet.getString("featuredPhotos"));
				aRent.setCreatedAt(resultSet.getDate("createdAt").toString());
				aRent.setUpdatedAt(resultSet.getDate("updatedAT").toString());
				rents.add(aRent);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rents;
	}
	
	public ArrayList<Rent> getAllRents(){
		ArrayList<Rent> rents = new ArrayList<Rent>();
		Connection connection = DatabaseManager.GetConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM rent WHERE ispublished =1";
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Rent aRent = new Rent();
				
				aRent.setRentId(resultSet.getInt("rentId"));
				aRent.setHouseId(resultSet.getInt("houseId"));
				aRent.setExtras(resultSet.getString("extras"));
				aRent.setNoOfRooms(resultSet.getString("noOfRooms"));
				aRent.setRentPerMonth(resultSet.getString("rentPerMonth"));
				aRent.setAdvance(resultSet.getString("advance"));
				aRent.setPhotos(resultSet.getString("photos"));
				aRent.setFeaturedPhotos(resultSet.getString("featuredPhotos"));
				aRent.setCreatedAt(resultSet.getDate("createdAt").toString());
				aRent.setUpdatedAt(resultSet.getDate("updatedAT").toString());
				rents.add(aRent);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rents;
	}
}
