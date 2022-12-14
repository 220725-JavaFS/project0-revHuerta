package com.revature.services;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;

public class AccountService {
	
	public AccountDAO accountDao = new AccountDAOImpl();
	
	public void newAccount(Account user) {
		accountDao.storeAccount(user);
	}
	
	public Account User(String user) {
		return accountDao.getAccountByUser(user);
	}

	public List<Account> AllUsers(){
		return accountDao.getAllUsers();
	}
	
	public boolean isUserRegistered(String user, String pwd) {
		return accountDao.getIsUserRegistered(user, pwd);
	}
	
	public boolean isOwner(String user) {
		return accountDao.getIsOwner(user);
	}
	
	public boolean isAdmin(String user) {
		return accountDao.getIsAdmin(user);
	}
	
	public void banUser(String user) {
		accountDao.banUser(user);
	}
	
	public void unbanUser(String user) {
		accountDao.unbanUser(user);
	}
	
	public double netFarmNetWorth(String farmName) {
		return accountDao.getFarmNetWorth(farmName);
	}
	
	public void updateUserCurrency(String userName, double currency) {
		accountDao.updateUserCurrency(userName, currency);
	}

}
