package bll;

import java.util.ArrayList;

import dao.RentDao;
import models.Rent;

public class RentManager {
	private RentDao aRentDao= new RentDao();
	
	public boolean insertRent(Rent aRent) {
		return aRentDao.insertRent(aRent) == 1;
	}
	
	public ArrayList<Rent> getAllRents(int houseId){
		return aRentDao.getAllRents(houseId);
	}
	public ArrayList<Rent> getAllRents(){
		return aRentDao.getAllRents();
	}
}
