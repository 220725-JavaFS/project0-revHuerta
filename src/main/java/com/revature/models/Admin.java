package com.revature.models;

/**
 * Levels of administrator roles (Highest to lowest): Master, Admin, Mod
 * Admins can assign mods, admins can ban players or owners(that are not admins)
 * Admins can assign Mods and Mods can timeout players
 */
public class Admin extends Account{
	
	public String role;
	public boolean isAdmin;
	
	
	public Admin(String name, String lastName, String userEmail, String userName, String userPwd, int userLevel,
			double userCurrency, boolean isUserBanned, String role, boolean isAdmin) {
		super(name, lastName, userEmail, userName, userPwd, userLevel, userCurrency, isUserBanned);
		this.role = role;
		this.isAdmin = isAdmin;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
