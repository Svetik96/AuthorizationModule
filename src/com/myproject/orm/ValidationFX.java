package com.myproject.orm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationFX {

	public static String errorMessageUsername = new String();
	public static String errorMessagePassword = new String();
	public static String errorMessageEmail = new String();
	public static String errorMessage = new String();
	
	public static boolean checkUsernameRepeats(String username){
		Connection dbConnection = null;
		Statement statement = null;
		
		boolean b = true;
		int count=0;
		String query = "SELECT COUNT(id) FROM users WHERE username='" + username + "'";
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
		if (count > 0) {
			b = false;
		}
		
		return b;
	}
		
	public static boolean checkUsernameAndPassword(String line){
		Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u005F]*[a-zA-Z\\d]{1}");
		Matcher m = p.matcher(line);
		return m.matches();
	}
	
	public static boolean checkEmail(String email){
		Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F\\u002D]*+@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	public static boolean checkEmailRepeats(String email){
		Connection dbConnection = null;
		Statement statement = null;
		
		boolean b = true;
		int count=0;
		String query = "SELECT COUNT(id) FROM users WHERE email='" + email + "'";
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
		if (count > 0) {
			b = false;
		}
		
		return b;
	}
	
	
	
	public static String validUsername(String username){
		boolean b = false;
		Scanner in = new Scanner(System.in);
		
		while (b == false) {
			if ((ValidationFX.checkUsernameRepeats(username) == true) &&
				(ValidationFX.checkUsernameAndPassword(username) == true)) {
				return username;
			} else if (ValidationFX.checkUsernameRepeats(username) == false) {
				errorMessage = "This username is already exist";
				//System.out.print("This username is already exist, please, write again: ");
				
			} else if (ValidationFX.checkUsernameAndPassword(username) == false) {
				errorMessage = "Invalid username";
				//System.out.print("Invalid username, please, write again: ");
				
			}
		}
		return username;
	}
	
	public static String validPassword(String password){
		Scanner in = new Scanner(System.in);
		
		if (ValidationFX.checkUsernameAndPassword(password) == true){
			return password;
		} else {
			while (ValidationFX.checkUsernameAndPassword(password) == false) {
				errorMessage = "Invalid password";
				if (ValidationFX.checkUsernameAndPassword(password) == true){
					return password;
				}
			}
				
				
			
		}
		return password;
	}
	
	public static String validEmail(String email){
		Scanner in = new Scanner(System.in);
		
		if (ValidationFX.checkEmail(email) == true){
			return email;
		} else {
			while (ValidationFX.checkEmail(email) == false) {
				errorMessage = "Invalid email";
				if (ValidationFX.checkEmail(email) == true){
					return email;
				}
			}
				
		}
		return email;
	}
	
}
