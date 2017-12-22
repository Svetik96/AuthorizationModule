package com.myproject.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.*;

public class DBConnection {
	public static Connection getConnection(){	
		Connection dbConnection = null;
				
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dbConnection = DriverManager.getConnection(PropertyProvider.getInstance().getProperty("db.host"), 
							PropertyProvider.getInstance().getProperty("db.login"), 
							PropertyProvider.getInstance().getProperty("db.password"));
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return dbConnection;
	}
}
