package com.jobSafari.model;

public class UserDetails {

	private Long id;
	private String userName;
	private String password;
	private Long mobileNo;
	public UserDetails() {}
	public UserDetails(Long id, String userName, String password, Long mobileNo) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userName=" + userName + ", password=" + password + ", mobileNo=" + mobileNo
				+ "]";
	}
	
	
}
