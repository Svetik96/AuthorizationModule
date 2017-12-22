package com.myproject.orm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyProvider {

	private static PropertyProvider instance;
	private Properties props = null;
	
	private PropertyProvider(){
		props = new Properties();
		try {
			FileInputStream configFile = new FileInputStream("properties/config.properties");
			props.load(configFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public synchronized static PropertyProvider getInstance(){
		if (instance == null) {
			instance = new PropertyProvider();
		}
		return instance;
	}
	
	public synchronized String getProperty (String key){
		String value = null;
		if (props.containsKey(key)) {
			value = props.getProperty(key);
		} else {
			System.out.println("Incorrect key");
		}
		return value;
	}
}
