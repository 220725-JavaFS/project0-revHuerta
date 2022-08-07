package com.revature.models;

public class Account {
	
	private String name;
	private String lastName;
	private String userEmail;
	private String userName;
	private String userPwd;
	private int userLevel;
	private double userCurrency;
	private boolean isUserBanned;
	private boolean isOwner;
	private boolean isAdmin;
	
	public Account() {
		super();
	}
	
	public Account(String userEmail, String userName, String userPwd) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public Account(String name, String lastName, String userEmail, String userName, String userPwd) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public Account(String name, String lastName, String userEmail, String userName, int userLevel, double userCurrency,
			boolean isUserBanned, boolean isOwner, boolean isAdmin) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userLevel = userLevel;
		this.userCurrency = userCurrency;
		this.isUserBanned = isUserBanned;
		this.isOwner = isOwner;
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "Account [name=" + name + ", lastName=" + lastName + ", userEmail=" + userEmail + ", userName="
				+ userName + ", userLevel=" + userLevel + ", userCurrency=" + userCurrency
				+ ", isUserBanned=" + isUserBanned + ", isOwner=" + isOwner + ", isAdmin=" + isAdmin + "]";
	}


	
	
}
