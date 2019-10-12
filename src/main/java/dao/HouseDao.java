package dao;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

import database.DatabaseManager;
import models.House;
import models.Owner;

public class HouseDao{
	public HouseDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertHouse(House aHouse) {
		System.out.println(aHouse.getOwnerId());
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO house (district,region,houseAddress,ownerId) VALUES(?,?,?,?)";
			PreparedStatement myPreparedStatement = connection.prepareStatement(query);
			myPreparedStatement.setString(1, aHouse.getDistrict());
			myPreparedStatement.setString(2, aHouse.getRegion());
			myPreparedStatement.setString(3, aHouse.getHouseAddress());
			myPreparedStatement.setInt(4, aHouse.getOwnerId());
		
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
	
	public ArrayList<House> getAllHouse(int ownerId){
		ArrayList<House> houses = new ArrayList<House>();
		Connection connection = DatabaseManager.GetConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM house WHERE ownerId ="+ownerId;
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				House aHouse = new House();
				
				aHouse.setHouseId(resultSet.getInt("houseId"));
				aHouse.setRegion(resultSet.getString("region"));
				aHouse.setDistrict(resultSet.getString("district"));
				aHouse.setHouseAddress(resultSet.getString("houseAddress"));
				
				houses.add(aHouse);
				
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
		return houses;
	}
}