package com.jobSifarish.DO;

public class UserDetailAuthorization {

	
	private String emailAddress;
	private String password;
	private String role;
	
	public UserDetailAuthorization(String emailAddress, String password, String role) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public UserDetailAuthorization() {
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserDetails [ emailAddress=" + emailAddress + ", password=" + password + ", mobileNo=" 
				+ "]";
	}
	
	
}
