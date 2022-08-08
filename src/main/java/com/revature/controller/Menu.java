package com.revature.controller;

import java.util.Scanner;
import com.revature.models.Account;
import com.revature.models.Farm;
import com.revature.services.AccountService;
import com.revature.services.FarmService;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	
	public void menu() {
		
		int input = 0;
		
		while(input != 3) {
			
			try {
				System.out.println("Welcome to my game!");
				System.out.println("\n----/ Menu Options /-----");
				System.out.println("1: Log In");
				System.out.println("2: Sign Up");
				System.out.println("3: Exit\n");
				System.out.print("Input: ");
				input = Integer.parseInt(scanner.nextLine());
				
			}catch(NumberFormatException e) {
				
				System.out.println("\nInvaild input...");
				
			}
			
			switch(input){
				
				case 1:
					logIn();
					break;
					
				case 2:
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
			
		}

	}
	
	public void newUserMenu() {
		
		RegisterAccount regAccount = new RegisterAccount();
		int input = 0;
		while(input != 2) {
			
			try {
				System.out.println("------------------//------------------");
				System.out.println("\n1: Make a New Account");
				System.out.println("2: Return to Main Menu\n");
				System.out.print("Input: ");
				input = Integer.parseInt(scanner.nextLine());
				
			}catch(NumberFormatException e) {
				
				System.out.println("\nInvaild input...");

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
					if(accountService.isOwner(userName) == true) {
						signedInOwner(userName);
						break;
					}else if(accountService.isAdmin(userName) == true) {
						signedInAdmin(userName);
						break;
					}
					signedInUser(userName);
					break;
			}
			
			System.out.println("User or Password was incorrect...");
			count++;
			if(count == 3) {
				System.out.println("\n------------------//------------------");
				System.out.println("Heading to Main Menu...");
				
			}

		}

	}
	
	private void signedInAdmin(String userName) {
		// TODO Auto-generated method stub
		
	}

	private void signedInOwner(String userName) {
		
		
		int input = 0;
		
		while(input != 6) {
			
			try {
				System.out.println("\n------------------//------------------");
				System.out.println("Welcome " + userName);
				
				System.out.println("1: Check Inventory");
				System.out.println("2: Plant");
				System.out.println("3: Harvest");
				System.out.println("4: Marketplace");
				System.out.println("5: Check Farm Status");
				System.out.println("6: Logout");
				
				System.out.print("Input: ");
				input = Integer.parseInt(scanner.nextLine());
				
			}catch(NumberFormatException e) {
				
			}
			
			switch(input){
				
				case 1:
					System.out.println("1: Check Inventory");
					break;
					
				case 2:
					System.out.println("2: Plant");
					break;
					
				case 3:
					System.out.println("3: Harvest");
					break;
					
				case 4:
					System.out.println("4: Marketplace");
					break;
					
				case 5:
					System.out.println("5: Check Farm Status");
					farmStatusMenu(userName);
					signedInOwner(userName);
					break;
					
				case 6:
					System.out.println("6: Logout");
					menu();
					break;
					
					
				default:
					System.out.println("------------------//------------------");
					System.out.println("Not a vaild input\n");
					break;
			}
			
			
		}
		
	}


	public void signedInUser(String user) {
		
		System.out.println("Welcome: " + user);
	}
	
	private void farmStatusMenu(String user) {
		System.out.println("------------------//------------------");
		AccountService accountService = new AccountService();
		FarmService fs = new FarmService();
		Farm farm = fs.getSingleFarm(user);
		
		System.out.println("Current Status of Your Farm: " + farm.getFarmName());
		System.out.println("\nFarm Name: " + farm.getFarmName());
		System.out.println("Farm Level: " + farm.getFarmLevel());
		System.out.println("Farm Owner: " + farm.getOwnerUser());
		System.out.println("Farmer One: " + farm.getFarmerOne());
		System.out.println("Farmer Two: " + farm.getFarmerTwo());
		System.out.println("Farmer Three: " + farm.getFarmerThree());
		
		System.out.println("\nWould you like to make changes to? Type \"Yes\" or \"No\" " + farm.getFarmName() + "?");
		System.out.print("Input: ");
		String input = scanner.nextLine();
		if(input.toLowerCase().trim().equals("yes")) {
			int choice = 0;
			
			while(choice != 5) {

				try {
					System.out.println("------------------//------------------");
					System.out.println("Which line would you like to make changes to?");
					System.out.println("\n(1) - Farm Name: " + farm.getFarmName());
					System.out.println("(2) - Farmer One: " + farm.getFarmerOne());
					System.out.println("(3) - Farmer Two: " + farm.getFarmerTwo());
					System.out.println("(4) - Farmer Three: " + farm.getFarmerThree());
					System.out.println("(5) - Stop making changes: ");
					
					System.out.print("Input: ");
					choice = Integer.parseInt(scanner.nextLine());
					
				}catch(NumberFormatException e) {
					System.out.println("\nNot a valid input...");
				}
				
			switch(choice){
				
				case 1:
					System.out.println("------------------//------------------");
					System.out.println("Making Changes to Farm Name...");
					System.out.println("What would you like your farm name to be?");
					String newFarmInput = scanner.nextLine(); 
					
					//add after able to check all farms
					
					
					break;
					
				case 2:
					System.out.println("------------------//------------------");
					System.out.println("Making Changes to Farmer One");
					System.out.println("Which User would you like to replace farmer one with?");
					String farmerInput = scanner.nextLine(); 
					
					Account farmer = accountService.User(farmerInput); 
					
					if(farmer != null && farmer.getFarmName() == null&& farm.getFarmerTwo() != farmerInput 
							&& farm.getFarmerThree() != farmerInput){//makes sure the user account exists and 
						// that the user is not currently in another farm or if the user is already a farmer in the same farm
						System.out.println("Adding " + farmer.getUserName() + " to farmer one!");
						fs.updateFarmerOne(farm.getFarmName(), farmerInput);
						
					}else {
						System.out.println("That user does not exist...Or that user is Already in your farm...");
					}
					break;
					
				case 3:
					System.out.println("------------------//------------------");
					System.out.println("Making Changes to Farmer Two");
					System.out.println("Which User would you like to replace farmer one with?");
					farmerInput = scanner.nextLine(); 
					
					farmer = accountService.User(farmerInput); 
					
					if(farmer != null && farmer.getFarmName() == null && farm.getFarmerOne() != farmerInput 
							&& farm.getFarmerThree() != farmerInput){//makes sure the user account exists and 
						// that the user is not currently in another farm or if the user is already a farmer in the same farm
						System.out.println("Adding " + farmer.getUserName() + " to farmer two!");
						fs.updateFarmerTwo(farm.getFarmName(), farmerInput);
						
					}else {
						System.out.println("That user does not exist...Or that user is Already in your farm...");
					}
					break;
					
				case 4:
					System.out.println("------------------//------------------");
					System.out.println("Making Changes to Farmer Three");
					System.out.println("Which User would you like to replace farmer one with?");
					farmerInput = scanner.nextLine(); 
					
					farmer = accountService.User(farmerInput); 
					
					if(farmer != null && farmer.getFarmName() == null && farm.getFarmerOne() != farmerInput 
							&& farm.getFarmerTwo() != farmerInput){//makes sure the user account exists and 
						// that the user is not currently in another farm or if the user is already a farmer in the same farm
						System.out.println("Adding " + farmer.getUserName() + " to farmer two!");
						fs.updateFarmerThree(farm.getFarmName(), farmerInput);
						
					}else {
						System.out.println("That user does not exist...Or that user is Already in your farm...");
					}
					break;
					
				case 5:

					break;
	
				default:
					System.out.println("------------------//------------------");
					System.out.println("Not a vaild input\n");
					break;
			}
				
			}
		}
		
		
	}
	

}
