package com.example.SpringBootBegining5.Entity;

public class JwtTokenClass {
	
	public JwtTokenClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtTokenClass(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	private String username;
	private String password;
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
	@Override
	public String toString() {
		return "JwtTokenClass [username=" + username + ", password=" + password + "]";
	}

}
