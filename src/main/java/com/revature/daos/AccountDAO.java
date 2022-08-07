package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface AccountDAO {

	public abstract void storeAccount(Account user);
	
	public abstract Account getAccountByUser(String user);
	
	 List<Account> getAllUsers();

	public abstract boolean getIsUserRegistered(String user, String pwd);
}
