package com.revature.services;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;

public class NewAccountService {
	
	private AccountDAO accountDao = new AccountDAOImpl();
	
	public void newAccount(Account user) {
		
		accountDao.storeAccount(user);

	}

}
