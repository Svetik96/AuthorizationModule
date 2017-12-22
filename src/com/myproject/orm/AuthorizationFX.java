package com.myproject.orm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizationFX {

	public static String errorMessage;
	public static String successfulEntry;
	
	public static void adminLogin(String login, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
				
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementRole = null;
		
		String checkPassword = "SELECT password FROM users WHERE username = ?";
		String checkRole = "SELECT role FROM users WHERE username = ?";
		
		try {
			dbConnection = DBConnection.getConnection();
			preparedStatement = dbConnection.prepareStatement(checkPassword);
			preparedStatement.setString(1, login);
			preparedStatementRole = dbConnection.prepareStatement(checkRole);
			preparedStatementRole.setString(1, login);
			
			ResultSet rs = preparedStatement.executeQuery();
			ResultSet rsRole = preparedStatementRole.executeQuery();
			
			
			if(rsRole.next() && rsRole.getBoolean(1) == true) {
				rs.next();
				if(Encryption.verifyPassword(rs.getString(1), password)) {
					successfulEntry = "Successful entry";
					System.out.println("Successful entry");
				} else {
					errorMessage = "Incorrect password";
					System.out.println("Incorrect password");
				}
			} else {
				errorMessage = "You are not admin";
				System.out.println("You are not admin");
			}
			
			rs.close();
			rsRole.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
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
	}
	
	public static void userLoginPassword(String login, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
				
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String checkPassword = "SELECT password FROM users WHERE username = ?";
		
		try {
			dbConnection = DBConnection.getConnection();
			preparedStatement = dbConnection.prepareStatement(checkPassword);
			preparedStatement.setString(1, login);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				if(Encryption.verifyPassword(rs.getString(1), password)) {
					successfulEntry = "Successful entry";
					System.out.println("Successful entry");
				} else {
					errorMessage = "Incorrect password";
					System.out.println("Incorrect password");
				}
			} else {
				errorMessage = "User doesn't exist";
				System.out.println("User doesn't exist");
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
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
	}
	
	public static void userLoginNumeric(String login, String numberString, int randomNumber) throws IOException, NoSuchAlgorithmException{
		
		BufferedReader fileIn = new BufferedReader(new FileReader("C:/Users/Sveta Ovcharuk/num.txt:sveta"));
		String systNum = fileIn.readLine();
		
		int number = Integer.parseInt(numberString);
		String suma = Encryption.encrypt2(randomNumber + number);
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String checkLogin = "SELECT COUNT(id) FROM users WHERE username = ?";
		
		if(suma.equals(systNum)) {
			try {
				dbConnection = DBConnection.getConnection();
				preparedStatement = dbConnection.prepareStatement(checkLogin);
				preparedStatement.setString(1, login);
				
				ResultSet rs = preparedStatement.executeQuery();
				
				if((rs.next()) && rs.getInt(1) == 1) {
					successfulEntry = "Successful entry";
					System.out.println("Successful entry");
				} else {
					errorMessage = "User doesn't exist";
					System.out.println("User doesn't exist");
				}
				
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
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
		} else {
			errorMessage = "Incorrect numeric";
			System.out.println("Incorrect numeric");
		}
	}
	
	public static void userLoginEmail(String login, String numberString, int randomNumber){
		int number = Integer.parseInt(numberString);
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String email = "SELECT email FROM users WHERE username = ?";
		
		try {
			dbConnection = DBConnection.getConnection();
			preparedStatement = dbConnection.prepareStatement(email);
			preparedStatement.setString(1, login);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {				
				
				if(number == randomNumber) {
					successfulEntry = "Successful entry";
					System.out.println("Successful entry");
				} else {
					errorMessage = "Incorrect code";
					System.out.println("Incorrect code");
				}
			} else {
				errorMessage = "User doesn't exist";
				System.out.println("User doesn't exist");
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
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
	}
	
}
