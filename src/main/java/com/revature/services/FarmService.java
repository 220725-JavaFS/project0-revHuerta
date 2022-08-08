package com.revature.services;

import com.revature.daos.FarmDAO;
import com.revature.daos.FarmDAOImpl;
import com.revature.models.Farm;

public class FarmService {
	
	private FarmDAO farmDao = new FarmDAOImpl();
	
	public Farm getSingleFarm(String userName) {
		return farmDao.getFarmByUserName(userName);
	}
	
	public void updateFarmName(String farmName, String userName) {
		farmDao.updateFarmName(farmName, userName);
	}
	
	public void updateFarmerOne(String farmName, String farmer) {
		farmDao.updateFarmerOne(farmName,farmer);
	}
	
	public void updateFarmerTwo(String farmName, String farmer) {
		farmDao.updateFarmerTwo(farmName,farmer);
	}
	
	public void updateFarmerThree(String farmName, String farmer) {
		farmDao.updateFarmerThree(farmName,farmer);
	}
}
