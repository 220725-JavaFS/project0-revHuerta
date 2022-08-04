package com.revature.controller;

import java.util.Scanner;

import com.revature.models.Account;

public class RegisterAccount {
	
	private Scanner scanner = new Scanner(System.in);
	
	public void register() {
		
		
		
		System.out.println("\n------------------//------------------");
		
		
		System.out.println("Name: ");
		String name = scanner.nextLine();
		
		System.out.println("Last Name: ");
		String lastName = scanner.nextLine();
		
		System.out.println("Email: ");
		String email = scanner.nextLine();
		
		System.out.println("UserName: ");
		String userName = scanner.nextLine();
		
		System.out.println("Password:");
		String pwd = scanner.nextLine();
		System.out.println("Retype Password");
		String pwd2 = scanner.nextLine();
		
		while(!pwd.equals(pwd2)) {
			
			System.out.println("Password:");
			String pwdTemp = scanner.nextLine();
			System.out.println("Retype Password");
			String pwdTemp2 = scanner.nextLine();
			
			if(pwdTemp.equals(pwdTemp2)) {
				pwd = pwdTemp;
				break;
			}
			
		}
		
		System.out.println("Welcome" + name + " User " + userName + "pwd:" + pwd);
		Account account = new Account(name, lastName, email, userName, pwd);
		
		


		
	}
}
