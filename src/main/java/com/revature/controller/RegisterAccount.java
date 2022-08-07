package com.revature.controller;

import java.util.Scanner;

import com.revature.models.Account;
import com.revature.services.AccountService;

public class RegisterAccount {
	
	private Scanner scanner = new Scanner(System.in);
	private AccountService accountService = new AccountService();
	public void register() {
		
		
		
		System.out.println("\n------------------//------------------");
		
		Account account = new Account();
		
		System.out.println("Name: ");
		account.setName(scanner.nextLine());
		
		System.out.println("Last Name: ");
		account.setLastName(scanner.nextLine());
		
		System.out.println("Email: ");
		account.setUserEmail(scanner.nextLine());
		
		System.out.println("UserName: ");
		account.setUserName(scanner.nextLine());
		
		System.out.println("Password:");
		String pwd = scanner.nextLine();
		System.out.println("Retype Password");
		String pwd2 = scanner.nextLine();
		
		while(!pwd.equals(pwd2)) {
			
			System.out.println("\n------------------//------------------");
			System.out.println("Passwords do not mach. Please Try again");
			System.out.println("Password:");
			String pwdTemp = scanner.nextLine();
			System.out.println("Retype Password");
			String pwdTemp2 = scanner.nextLine();
			
			if(pwdTemp.equals(pwdTemp2)) {
				pwd = pwdTemp;

				break;
			}
			
		}
		
		account.setUserPwd(pwd);
		accountService.newAccount(account);

		System.out.println("...Signed up!\n");


		
	}
}
