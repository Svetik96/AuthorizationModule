package com.myproject.orm;

public class User implements java.io.Serializable {
	
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String surname;
	private boolean role;
	
/*	public Users(String username, String password, String email, String first_name, String surname, boolean role)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.first_name = first_name;
		this.surname = surname;
		this.role = role;
	}
*/	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	public void setRole(boolean role){
		this.role = role;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public boolean getRole(){
		return role;
	}
}
