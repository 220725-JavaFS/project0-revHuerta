package com.revature.services;

import com.revature.models.Account;

public class NewAccountService {
	
	private Account account = new Account();
	public void newAccount(Account user) {
		
		user.setName(user.getLastName());
		
		
		
	}

}
