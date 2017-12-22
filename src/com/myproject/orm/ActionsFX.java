package com.myproject.orm;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ActionsFX {
	
	public static String newUser = new String();

	public static User createUser(String username, String password, String email, String firstname, String lastname){
		User user = new User();
		
		user.setUsername(ValidationFX.validUsername(username));
		
		user.setPassword(ValidationFX.validPassword(password));
		
		user.setEmail(ValidationFX.validEmail(email));
		
		user.setFirstName(firstname);
		
		user.setSurname(lastname);
		
		user.setRole(false);
		
		return user;
	}
	
	public static void addUser(String username, String password, String email, String firstname, String lastname) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		Connection dbConnection = null;
		Statement statement = null;
				
		//User user = ActionsFX.createUser(username, password, email, firstname, lastname);
		
		String encryptPassword = Encryption.encrypt(password);
		
		String addUser = "INSERT INTO users "
				+ "(username, password, email, firstName, surname, role) "
				+ "values ('"
				+ username + "', '" + encryptPassword + "', '" 
				+ email + "', '" + firstname + "', '" 
				+ lastname + "', 'false')";
				
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			statement.executeUpdate(addUser);
			newUser = "New user created";
			System.out.println("New user created");
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
	}
	
}
