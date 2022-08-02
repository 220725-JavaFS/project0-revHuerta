package com.revature.repos;

public class User {
	
	private String name;
	private String userEmail;
	private String userName;
	private String userPwd;
	private String userRole;
	private int userLevel;
	private double userCurrency;
	private boolean isUserBanned;
	
	public User() {
		super();
	}
	
	public User(String name, String userEmail, String userName, String userPwd, String userRole, int userLevel,
			double userCurrency, boolean isUserBanned) {
		super();
		this.name = name;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRole = userRole;
		this.userLevel = userLevel;
		this.userCurrency = userCurrency;
		this.isUserBanned = isUserBanned;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public double getUserCurrency() {
		return userCurrency;
	}

	public void setUserCurrency(double userCurrency) {
		this.userCurrency = userCurrency;
	}

	public boolean isUserBanned() {
		return isUserBanned;
	}

	public void setUserBanned(boolean isUserBanned) {
		this.isUserBanned = isUserBanned;
	}
	
	
}
