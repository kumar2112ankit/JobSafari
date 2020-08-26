package com.jobSifarish.model;

public class UserDetailsAuthanticion {

	
	private String userName;
	private String password;
	private String role;
	
	public UserDetailsAuthanticion(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserDetailsAuthanticion() {}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserDetails [ userName=" + userName + ", password=" + password + ", mobileNo=" 
				+ "]";
	}
	
	
}
