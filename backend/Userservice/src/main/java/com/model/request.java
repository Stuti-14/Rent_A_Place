package com.model;

public class request {
	private String username;
	private String password;
	
	
	public request(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public request()
	{
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
