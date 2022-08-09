package com.revature.daos;

import java.util.List;

import com.revature.models.Farm;

public interface FarmDAO {

	Farm getFarmByUserName(String userName);
	
	void updateFarmName(String farmName, String userName);

	void updateFarmerOne(String farmName, String farmer);
	
	void updateFarmerTwo(String farmName, String farmer);
	
	void updateFarmerThree(String farmName, String farmer);

	List<Farm> getAllFarms();

	void storeFarm(Farm user);

}
