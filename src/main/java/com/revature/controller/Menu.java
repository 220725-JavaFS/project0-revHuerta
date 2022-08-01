package com.revature.controller;

import java.util.Scanner;

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
				System.out.println("\n1: Log In");
				System.out.println("2: Sign Up");
				System.out.println("3: Exit\n");
			}
			
			switch(input){
				
				case 1:
					System.out.println("Entered 1");
					break;
					
				case 2:
					System.out.println("Entered 2");
					break;
					
				case 3:
					System.out.println("Closing gaming...");
					System.exit(0);;
					break;
					
				default:
					System.out.println("Not a vaild input");
					break;
			}
			
			System.out.print("Input: ");
			
		}




	}
}
