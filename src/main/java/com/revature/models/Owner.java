package com.revature.models;

public class Owner extends Account {
	
	public String farmName;
	public int farmLevel;
	public boolean isOwner;
	public boolean isAdmin;

	public Owner() {
		super();
	}

	public Owner(String name, String lastName, String userEmail, String userName, String userPwd, int userLevel,
			double userCurrency, boolean isUserBanned, String farmName, int farmLevel, boolean isOwner,
			boolean isAdmin) {
		super();
		this.farmName = farmName;
		this.farmLevel = farmLevel;
		this.isOwner = isOwner;
		this.isAdmin = isAdmin;
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

	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	

}
