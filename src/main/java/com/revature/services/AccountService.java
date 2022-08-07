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

}
