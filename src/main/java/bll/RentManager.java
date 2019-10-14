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
	
	public Rent getAPublishedRent(int rentId) {
		return this.aRentDao.getAPublishedRent(rentId);
	}
	public Rent getARent(int rentId) {
		return this.aRentDao.getARent(rentId);
	}
	public boolean isUpdated(Rent aRent) {
		return this.aRentDao.updateRent(aRent)>0;
	}
	
	public boolean isDeleted(int rentId) {
		return this.aRentDao.deleteRent(rentId)>0;
	}
	
	public boolean isUpdatedImpression(int rentid) {
		return this.aRentDao.updateImpression(rentid)>0;
	}
}
