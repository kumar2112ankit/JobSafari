package com.jobSafari.model;

public class UserDetailsAuthanticion {

	
	private String userName;
	private String password;
	
	public UserDetailsAuthanticion() {}
	public UserDetailsAuthanticion(Long id, String userName, String password, Long mobileNo) {
		
		this.userName = userName;
		this.password = password;
		
	}
	
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
