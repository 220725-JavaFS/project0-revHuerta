package com.revature.controller;

import java.util.Scanner;

import com.revature.services.AccountService;

public class LoginAccount {

	private Scanner scanner = new Scanner(System.in);
	private AccountService accountService = new AccountService();

	public void logIn() {

		System.out.println("\n------------------//------------------");
		
		int count = 0;
		while(count !=3) {

			System.out.println("Username: ");
			String userName = scanner.nextLine();
			if(accountService.User(userName) != null){
				System.out.println("Password: ");
				String userPwd= scanner.nextLine();
				if(accountService.isUserRegistered( userName, userPwd)) {
					signedInMenu(userName);
				}
			}
			
			System.out.println("User or Password was incorrect...");
			count++;

		}
		System.out.println("\n------------------//------------------");
		System.out.println("Heading to Main Menu...");
	}
	
	public void signedInMenu(String user) {
		
		System.out.println("Welcome: " + user);
	}
}
