package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface AccountDAO {

	public abstract void storeAccount(Account user);
	
	public abstract Account getAccountByUser(String user);
	
	List<Account> getAllUsers();

	public abstract boolean getIsUserRegistered(String user, String pwd);

	public abstract boolean getIsOwner(String user);

	public abstract boolean getIsAdmin(String user);

	public abstract void banUser(String user);

	public abstract void unbanUser(String user);

	public abstract double getFarmNetWorth(String farmName);
}
