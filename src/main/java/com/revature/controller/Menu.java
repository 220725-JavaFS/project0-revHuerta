package com.revature.controller;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Farm;
import com.revature.models.Market;
import com.revature.services.AccountService;
import com.revature.services.FarmService;
import com.revature.services.MarketService;

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
				if(accountService.User(userName).isUserBanned() != true){
					if(accountService.isAdmin(userName) == true) {
						signedInAdmin(userName);
						break;
					}else if(accountService.isOwner(userName) == true) {
						signedInOwner(userName);
						break;
					}
					signedInUser(userName);
					break;
				}else {
					System.out.println("Your account: " + userName + " is banned");
					break;
				}
				
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
		System.out.println("\n------------------//------------------");
		System.out.println("Welcome " + userName);
		
		int input = 0;

		while(input != 7) {
			AccountService accountService = new AccountService();
			List<Account> list = accountService.AllUsers();
			try {
				System.out.println("What Would you like to do today?"
						+ "\n1: List all Account Info"
						+ "\n2: Search Account Info By User"
						+ "\n3: Ban a User"
						+ "\n4: Unban a User"
						+ "\n5: Check bannned Users"
						+ "\n6: Play the game "
						+ "\n7: Logout");
				System.out.print("Input: ");
				input = Integer.parseInt(scanner.nextLine());

			}catch(NumberFormatException e) {

			}
			switch(input){
			
			case 1:
				System.out.println("1: List all Account Info");
				
				for(Account a:list) {
					System.out.println("Name: " + a.getName() +" || LastName: " + a.getLastName() + ""
							+ " || Email: " + a.getUserEmail() + " || Username: " + a.getUserName() +""
									+ " || Level: " + a.getUserLevel() + " || Currency: $" + a.getUserCurrency()+ ""
											+ " || Banned: " + a.isUserBanned() + " || Farm Owner: " + a.isOwner()+""
													+ " || Admin: " + a.isAdmin());
				}
				break;
				
			case 2:
				System.out.println("2: Search Account Info By User");
				System.out.println("Enter Username: ");
				String user = scanner.nextLine();
				if(accountService.User(user) != null) {
					System.out.println(accountService.User(user));
					
				}else {
					System.out.println(user +" does not exist");
				}
				
				break;
				
			case 3:
				System.out.println("3: Ban a User");
				System.out.println("Enter Username: ");
				user = scanner.nextLine();
				if(accountService.User(user) != null) {
					//System.out.println(accountService.User(user));
					if(accountService.User(user).isUserBanned() != true) {
						accountService.banUser(user);
						System.out.println(user + " has been banned");
					}else {
						System.out.println(user + " is already banned");
					}
						
				}else {
					System.out.println(user +" does not exist");
				}
				break;
				
			case 4:
				System.out.println("4: Unban a User");
				System.out.println("Enter Username: ");
				user = scanner.nextLine();
				if(accountService.User(user) != null) {
					//System.out.println(accountService.User(user));
					if(accountService.User(user).isUserBanned() != false) {
						accountService.unbanUser(user);
						System.out.println(user + " has been unbanned");
					}else {
						System.out.println(user + " is already unbanned");
					}
						
				}else {
					System.out.println(user +" does not exist");
				}
				break;
				
			case 5:
				System.out.println("5: Check bannned Users");
				
				for(Account a:list) {
					if(a.isUserBanned() == true) {
						System.out.println("Username: " + a.getUserName());
					}
				}
				
				break;
				
			case 6:
				if(accountService.isOwner(userName) == true) {
					signedInOwner(userName);
				}
				signedInUser(userName);
				break;
			case 7:
				menu();
				break;
				
			default:
				System.out.println("------------------//------------------");
				System.out.println("Not a vaild input\n");
				break;
		}
			
		}
		
	}

	private void signedInOwner(String userName) {
		AccountService accountService = new AccountService();
		
		int input = 0;
		
		while(input != 6) {
			
			try {

				if(accountService.User(userName).isAdmin() == true) {
					System.out.println("\n------------------//------------------");
					System.out.println("Welcome " + userName);
					
					System.out.println("1: Check Inventory (Feature coming soon!)");
					System.out.println("2: Plant (Feature coming soon!)");
					System.out.println("3: Harvest (Feature coming soon!)");
					System.out.println("4: Marketplace ");
					System.out.println("5: Check Farm Status");
					System.out.println("6: Logout");
					System.out.println("7: Admin Menu");
					input = Integer.parseInt(scanner.nextLine());
					if(input == 7) {
						signedInAdmin(userName);
					}
				}else{
					System.out.println("\n------------------//------------------");
					System.out.println("Welcome " + userName);

					System.out.println("1: Check Inventory (Feature coming soon!)");
					System.out.println("2: Plant (Feature coming soon!)");
					System.out.println("3: Harvest (Feature coming soon!)");
					System.out.println("4: Marketplace");
					System.out.println("5: Check Farm Status");
					System.out.println("6: Logout");
					System.out.print("Input: ");
					input = Integer.parseInt(scanner.nextLine());
				}
				
			}catch(NumberFormatException e) {
				
			}
			
			switch(input){
				
				case 1:
					System.out.println("1: Check Inventory");
					break;
					
				case 2:
					System.out.println("2: Plant (Feature coming soon!)");
					break;
					
				case 3:
					System.out.println("3: Harvest (Feature coming soon!)");
					break;
					
				case 4:
					marketMenu(userName);
					break;
					
				case 5:
					System.out.println("5: Check Farm Status");
					farmStatusMenu(userName);
					signedInOwner(userName);
					break;
				case 6:
					menu();
					break;
					
				default:
					System.out.println("------------------//------------------");
					System.out.println("Not a vaild input\n");
					break;
			}
			
			
		}
		
	}


	public void signedInUser(String userName) {
		AccountService accountService = new AccountService();
		FarmService farmService = new FarmService();
		int input = 0;
		
		while(input != 6) {
			
			try {
				System.out.println("\n------------------//------------------");
				System.out.println("Welcome " + userName);
				
				System.out.println("1: Check Inventory (Feature coming soon!)");
				System.out.println("2: Plant (Feature coming soon!)");
				System.out.println("3: Harvest (Feature coming soon!)");
				System.out.println("4: Marketplace");
				System.out.println("5: Check Farm Status");
				System.out.println("6: Logout");
				
				System.out.print("Input: ");
				input = Integer.parseInt(scanner.nextLine());
				
			}catch(NumberFormatException e) {
				
			}
			
			switch(input){
				
				case 1:
					System.out.println("1: Check Inventory (Feature coming soon!)");
					
					break;
					
				case 2:
					System.out.println("2: Plant (Feature coming soon!)");
					break;
					
				case 3:
					System.out.println("3: Harvest (Feature coming soon!)");
					break;
					
				case 4:
					System.out.println("Marketplace");
					marketMenu(userName);
					break;
					
				case 5:
					System.out.println("5: Check Farm Status");
					if(accountService.User(userName).getFarmName() != null) {
						farmStatusMenu(userName);
					}else{
						System.out.println("Looks like you're not currently in a Farm "
								+ "\nWould you like to \"Join\" or \"Make\" a new Farm OR (Hit Enter To Return to Menu)");
						String choice = scanner.nextLine();
						if(!choice.equals("")) {
							if(choice.toLowerCase().trim().equals("join")) {
								//add join
							}else if(choice.toLowerCase().trim().equals("make")) {
								Farm farm = new Farm();
								System.out.println("Enter the farm name:");
								String farmName = scanner.nextLine();
								List<Farm> list = farmService.allFarms();
								boolean flag = false;
								for(Farm f:list) {

									if(f.getFarmName().equals(farmName)) {
										flag = true;
									}
								}
								
								if(flag == false) {
									farm.setFarmName(farmName);
									farm.setOwnerUser(userName);
									
									farmService.newFarm(farm);
									System.out.println(userName + " " + farmName + " farm was created");
								}else{
									System.out.println(farmName + "name already exist");
								}
								

								
							}
						}
					}
					break;

				default:
					System.out.println("------------------//------------------");
					System.out.println("Not a vaild input\n");
					break;
			}
			
			
		}
		
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
		System.out.println("Farm networth(sum of all farmers): " + accountService.netFarmNetWorth(farm.getFarmName()));
		//Display Current NW, add all user currency and display it to the User
		if(accountService.User(user).isOwner() == true) {
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

						//Checks the Farm Table in DB, 
						List<Farm> list = fs.allFarms();
						boolean flag = false;
						for(Farm f:list) {

							if(f.getFarmName().equals(newFarmInput)) {
								flag = true;
							}
						}
						if(flag == false) {
							fs.updateFarmName(farm.getFarmName(), newFarmInput);
						}else {
							System.out.println(newFarmInput + " name is already taken. Please Choose another Farm Name "
									+ "\nCurrent Taken Farm Names:\n");
							for(Farm f:list) {
								System.out.println("Farm Name: " + f.getFarmName());
							}
						}

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
	
	public void marketMenu(String userName) {
		MarketService marketService = new MarketService();
		AccountService accountService = new AccountService();

		int input = 0;

		while(input != 3) {

			try {
				System.out.println("\n----/ Market Options /-----");
				System.out.println(userName + " Wallet: $ " + accountService.User(userName).getUserCurrency());
				System.out.println("1: MarketPlace");
				System.out.println("2: Donate to another Player");
				System.out.println("3: Leave Market\n");
				System.out.print("Input: ");
				input = Integer.parseInt(scanner.nextLine());

			}catch(NumberFormatException e) {

				System.out.println("\nInvaild input...");

			}

			switch(input){

			case 1:
				System.out.println("\"\n----------/Items For Sale/----------\"");
				List<Market> marketList = marketService.allMarkets();
				for(Market mk:marketList) {
					System.out.println("Market Name: " + mk.getMarketName() + " Item: " + mk.getSeeds() + ""
							+ " Stock: " + mk.getStock() + " Price: $" + mk.getPrice());
				}
				System.out.println("\nWould you like to buy an item? Type \"Yes\" or \"No\" ");
				System.out.print("Input: ");
				String choice = scanner.nextLine();
				if(choice.toLowerCase().trim().equals("yes")) {
					System.out.println("Type the item in which you would like to purchase");
					System.out.print("Input: ");
					choice = scanner.nextLine().toLowerCase().trim();
					if(marketService.getItem(choice) != null && marketService.getItem(choice).getSeeds() !=null) {
						if(marketService.getItem(choice).getStock() > 0) {
							System.out.println("How many " + choice + " would you like to buy?");
							System.out.print("Input: ");
							try {
								int input2 = Integer.parseInt(scanner.nextLine());
								if(input2 > 0) {
									if(marketService.getItem(choice).getStock() - input2 < 0) {
										System.out.println("You can not buy more than " +input2+ " " + choice + "."
												+ "\n There is only " +  marketService.getItem(choice).getStock() + " in stock");
									}else {
										marketService.updateStock(choice, marketService.getItem(choice).getStock() - input2);
										accountService.updateUserCurrency(userName, accountService.User(userName).getUserCurrency() - marketService.getItem(choice).getPrice()*input2);
									}
								}else {
									System.out.println("Invalid Input...:" + input);
								}
								
							}catch(NumberFormatException e) {

								System.out.println("\nInvaild input...");

							}
						}else {
							System.out.println(choice +": Item is out of stock");
						}
						
					}
					else {
						System.out.println(choice + ": Item does not exist in marketplace");
					}
					
					
				}
				break;

			case 2:
				donationsMenu(userName);
				break;

			default:
				System.out.println("------------------//------------------");
				System.out.println("Not a vaild input\n");
				break;
			}

		}
	}
	
	public void donationsMenu(String userName) {
		AccountService accountService = new AccountService();

		String input = "";

		while(!input.toLowerCase().trim().equals("exit")) {

			try {
				System.out.println("\n----/ Market Options /-----");
				System.out.println(userName + " Wallet: $ " + accountService.User(userName).getUserCurrency());
				System.out.println("Enter the Player UserName to donate");
				System.out.println("Type \"Exit\" to return to Market");
				System.out.print("Input: ");
				input = scanner.nextLine();
				int amount = 0;
				if(accountService.User(input) != null) {
					System.out.print("Enter amount: $");
					amount = Integer.parseInt(scanner.nextLine());
					if(amount > 0) {
						if(amount <= accountService.User(userName).getUserCurrency()) {
							accountService.updateUserCurrency(userName, accountService.User(userName).getUserCurrency() - amount);
							accountService.updateUserCurrency(input, accountService.User(input).getUserCurrency() + amount);
						}else {
							System.out.println("You have insufficient funds: "
									+ "\nYour Current Wallet: $" + accountService.User(userName).getUserCurrency());
						}
					}else {
						System.out.println("Can not enter that amount: " + amount);
					}
					

					
				}else {
					System.out.println(input + " user does not exist");
				}
				

			}catch(NumberFormatException e) {

				System.out.println("\nInvaild input...");

			}

		}
	}

}
