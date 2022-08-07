package com.revature.controller;

import java.util.Scanner;

import com.revature.services.AccountService;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	
	public void menu() {
		
		System.out.println("Welcome to my game!");
		
		System.out.println("1: Log In");
		System.out.println("2: Sign Up");
		System.out.println("3: Exit\n");
		System.out.print("Input: ");
		
		int input = 0;
		
		while(input != 3) {
			
			try {
				
				input = Integer.parseInt(scanner.nextLine());
				
			}catch(NumberFormatException e) {
				
				System.out.println("\n----/ Menu Options /-----");
				System.out.println("\n1: Log In");
				System.out.println("2: Sign Up");
				System.out.println("3: Exit\n");
				
			}
			
			switch(input){
				
				case 1:
					System.out.println("Entered 1");
					logIn();
					//menu();
					break;
					
				case 2:
					System.out.println("Entered 2");
					newUserMenu();
					break;
					
				case 3:
					System.out.println("Closing game...");
					System.exit(0);;
					break;
					
				default:
					System.out.println("------------------//------------------");
					System.out.println("Not a vaild input\n");
					break;
			}
			
			System.out.print("Input: ");
			
		}

	}
	
	public void newUserMenu() {
		
		
		
		System.out.println("------------------//------------------");
		System.out.println("\n1: Make a New Account");
		System.out.println("2: Return to Main Menu\n");
		System.out.print("Input: ");
		
		RegisterAccount regAccount = new RegisterAccount();
		int input = 0;
		while(input != 2) {
			
			try {
				
				input = Integer.parseInt(scanner.nextLine());
				
			}catch(NumberFormatException e) {
				
				System.out.println("\n------------------//------------------");
				System.out.println("\n1: Make a New Account");
				System.out.println("2: Return to Main Menu\n");

			}
			
			switch(input){
				
				case 1:
					System.out.println("\n------------------//------------------");
					System.out.println("Making New Account!");
					regAccount.register();
					menu();
					break;
					
				case 2:
					System.out.println("\n------------------//------------------");
					System.out.println("Heading to Main Menu...");
					break;
					
				default:
					System.out.println("Not a vaild input");
					break;
			}
			
			System.out.print("Input: ");
			
		}
		
	}
	
	public void logIn() {

		System.out.println("\n------------------//------------------");
		AccountService accountService = new AccountService();
		int count = 0;
		while(count !=3) {

			System.out.println("Username: ");
			String userName = scanner.nextLine();
			System.out.println("Password: ");
			String userPwd= scanner.nextLine();
			if(accountService.User(userName) != null && accountService.isUserRegistered( userName, userPwd) !=false ){
					signedInMenu(userName);
					break;
			}
			
			System.out.println("User or Password was incorrect...");
			count++;
			if(count == 3) {
				System.out.println("\n------------------//------------------");
				System.out.println("Heading to Main Menu...");
				
			}

		}
		menu();

	}
	
	public void signedInMenu(String user) {
		
		System.out.println("Welcome: " + user);
	}
	

}
