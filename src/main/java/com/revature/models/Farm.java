package com.revature.models;

public class Farm {
	
	private String farmName;
	private int farmLevel;
	private String ownerUser;
	private String farmerOne;
	private String farmerTwo;
	private String farmerThree;
	
	public Farm() {
		super();
	}

	public Farm(String farmName, int farmLevel, String ownerUser, String farmerOne, String farmerTwo,
			String farmerThree) {
		super();
		this.farmName = farmName;
		this.farmLevel = farmLevel;
		this.ownerUser = ownerUser;
		this.farmerOne = farmerOne;
		this.farmerTwo = farmerTwo;
		this.farmerThree = farmerThree;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public int getFarmLevel() {
		return farmLevel;
	}

	public void setFarmLevel(int farmLevel) {
		this.farmLevel = farmLevel;
	}

	public String getOwnerUser() {
		return ownerUser;
	}

	public void setOwnerUser(String ownerUser) {
		this.ownerUser = ownerUser;
	}

	public String getFarmerOne() {
		return farmerOne;
	}

	public void setFarmerOne(String farmerOne) {
		this.farmerOne = farmerOne;
	}

	public String getFarmerTwo() {
		return farmerTwo;
	}

	public void setFarmerTwo(String farmerTwo) {
		this.farmerTwo = farmerTwo;
	}

	public String getFarmerThree() {
		return farmerThree;
	}

	public void setFarmerThree(String farmerThree) {
		this.farmerThree = farmerThree;
	}

	@Override
	public String toString() {
		return "Farm [farmName=" + farmName + ", farmLevel=" + farmLevel + ", ownerUser=" + ownerUser + ", farmerOne="
				+ farmerOne + ", farmerTwo=" + farmerTwo + ", farmerThree=" + farmerThree + "]";
	}
	
	
	
	
}
