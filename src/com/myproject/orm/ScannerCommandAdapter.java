package com.myproject.orm;

import java.util.Scanner;

public class ScannerCommandAdapter {
	
	public static String newUsername(){
		Scanner in = new Scanner(System.in);
		String username = in.nextLine();
		return username;
	}
	
	public static String newPassword(){
		Scanner in = new Scanner(System.in);
		String password = in.nextLine();
		return password;
	}
	
	public static String newEmail(){
		Scanner in = new Scanner(System.in);
		String email = in.nextLine();
		return email;
	}
	
	public static String newFirstname(){
		Scanner in = new Scanner(System.in);
		String firstName = in.nextLine();
		return firstName;
	}
	
	public static String newSurname(){
		Scanner in = new Scanner(System.in);
		String surname = in.nextLine();
		return surname;
	}
	
	public static boolean newRole(){
		Scanner in = new Scanner(System.in);
		boolean role = in.nextBoolean();
		return role;
	}	
	
	public static int newNumber(){
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		return number;
	}
}
