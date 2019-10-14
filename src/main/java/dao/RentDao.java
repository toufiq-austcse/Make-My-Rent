package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DatabaseManager;
import models.House;
import models.Owner;
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
				aRent.setIspublish(resultSet.getBoolean("ispublished"));
				aRent.setPhotos(resultSet.getString("photos"));
				aRent.setImpression(resultSet.getInt("impression"));
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
			String query = "SELECT rent.*,house.* FROM rent INNER JOIN house ON house.houseId = rent.houseId WHERE rent.isPublished = 1";
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Rent aRent = new Rent();
				House aHouse = new House();
				
				aRent.setRentId(resultSet.getInt("rentId"));
				aRent.setHouseId(resultSet.getInt("houseId"));
				aRent.setExtras(resultSet.getString("extras"));
				aRent.setNoOfRooms(resultSet.getString("noOfRooms"));
				aRent.setRentPerMonth(resultSet.getString("rentPerMonth"));
				aRent.setAdvance(resultSet.getString("advance"));
				aRent.setPhotos(resultSet.getString("photos"));
				aRent.setImpression(resultSet.getInt("impression"));
				aRent.setFeaturedPhotos(resultSet.getString("featuredPhotos"));
				aRent.setCreatedAt(resultSet.getDate("createdAt").toString());
				aRent.setUpdatedAt(resultSet.getDate("updatedAT").toString());
				
				aHouse.setDistrict(resultSet.getString("district"));
				aHouse.setHouseAddress(resultSet.getString("houseAddress"));
				aHouse.setRegion(resultSet.getString("region"));
				aHouse.setOwnerId(resultSet.getInt("ownerId"));
				
				aRent.setHouse(aHouse);
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
	
	public Rent getAPublishedRent(int rentId){
		Rent aRent = new Rent();
		Connection connection = DatabaseManager.GetConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT rent.*,house.*,owner.* FROM rent INNER JOIN house ON house.houseId = rent.houseId"
					+ " INNER JOIN owner ON owner.ownerId = house.ownerId WHERE rent.isPublished = 1 AND rentId ="+rentId;
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				
				House aHouse = new House();
				Owner aOwner = new Owner();
				
				aRent.setRentId(resultSet.getInt("rentId"));
				aRent.setHouseId(resultSet.getInt("houseId"));
				aRent.setExtras(resultSet.getString("extras"));
				aRent.setNoOfRooms(resultSet.getString("noOfRooms"));
				aRent.setRentPerMonth(resultSet.getString("rentPerMonth"));
				aRent.setAdvance(resultSet.getString("advance"));
				aRent.setPhotos(resultSet.getString("photos"));
				aRent.setImpression(resultSet.getInt("impression"));
				System.out.println("Impression "+resultSet.getInt("impression"));
				aRent.setFeaturedPhotos(resultSet.getString("featuredPhotos"));
				aRent.setCreatedAt(resultSet.getDate("createdAt").toString());
				aRent.setIspublish(resultSet.getBoolean("isPublished"));
				aRent.setUpdatedAt(resultSet.getDate("updatedAT").toString());
				
				aHouse.setDistrict(resultSet.getString("district"));
				aHouse.setHouseAddress(resultSet.getString("houseAddress"));
				aHouse.setRegion(resultSet.getString("region"));
				aHouse.setOwnerId(resultSet.getInt("ownerId"));
				
				aOwner.setFirstName(resultSet.getString("firstName"));
				aOwner.setLastName(resultSet.getString("lastName"));
				aOwner.setEmail(resultSet.getString("email"));
				aOwner.setPhoneNumber(resultSet.getString("phoneNumber"));
				
				aRent.setHouse(aHouse);
				aRent.setaOwner(aOwner);
				
				
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
		return aRent;
	}
	
	public Rent getARent(int rentId){
		Rent aRent = new Rent();
		Connection connection = DatabaseManager.GetConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT rent.*,house.*,owner.* FROM rent INNER JOIN house ON house.houseId = rent.houseId"
					+ " INNER JOIN owner ON owner.ownerId = house.ownerId WHERE rentId ="+rentId;
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				
				House aHouse = new House();
				Owner aOwner = new Owner();
				
				aRent.setRentId(resultSet.getInt("rentId"));
				aRent.setHouseId(resultSet.getInt("houseId"));
				aRent.setExtras(resultSet.getString("extras"));
				aRent.setNoOfRooms(resultSet.getString("noOfRooms"));
				aRent.setRentPerMonth(resultSet.getString("rentPerMonth"));
				aRent.setAdvance(resultSet.getString("advance"));
				aRent.setPhotos(resultSet.getString("photos"));
				aRent.setFeaturedPhotos(resultSet.getString("featuredPhotos"));
				aRent.setCreatedAt(resultSet.getDate("createdAt").toString());
				aRent.setIspublish(resultSet.getBoolean("isPublished"));
				aRent.setUpdatedAt(resultSet.getDate("updatedAT").toString());
				
				aHouse.setDistrict(resultSet.getString("district"));
				aHouse.setHouseAddress(resultSet.getString("houseAddress"));
				aHouse.setRegion(resultSet.getString("region"));
				aHouse.setOwnerId(resultSet.getInt("ownerId"));
				
				aOwner.setFirstName(resultSet.getString("firstName"));
				aOwner.setLastName(resultSet.getString("lastName"));
				aOwner.setEmail(resultSet.getString("email"));
				aOwner.setPhoneNumber(resultSet.getString("phoneNumber"));
				
				aRent.setHouse(aHouse);
				aRent.setaOwner(aOwner);
				
				
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
		return aRent;
	}
	public int updateRent(Rent aRent) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "UPDATE rent SET noOfRooms ='" + aRent.getNoOfRooms() + "',extras='"
					+ aRent.getExtras() + "',rentPerMonth='" + aRent.getRentPerMonth()
					+ "',advance='" + aRent.getAdvance()+"', isPublished ="+aRent.isIspublish() + " WHERE rentId =" + aRent.getRentId();

			res = statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	public int deleteRent(int rentId) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "DELETE FROM rent WHERE rentId ="+rentId;
			
			res = statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return res;
	}
	
	public int updateImpression(int rentId) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "UPDATE rent SET impression = impression + 1 WHERE rentId = "+rentId;
			res = statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
}
