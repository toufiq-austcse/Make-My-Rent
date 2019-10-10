package bll;

import java.util.ArrayList;

import dao.HouseDao;
import models.House;
import models.Owner;

public class HouseManager {
	private HouseDao aHouseDao ;
	public HouseManager() {
		this.aHouseDao = new HouseDao();
	}
	
	public boolean insertHouse(House aHouse) {
		
		return this.aHouseDao.insertHouse(aHouse) == 1;
	}
	public ArrayList<House> getAllHouse(int ownerId){
		return this.aHouseDao.getAllHouse(ownerId);
	}
}
