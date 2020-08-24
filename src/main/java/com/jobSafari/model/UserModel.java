package com.jobSafari.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Table
@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	@NotNull
	@Column(unique = true,length = 200,nullable = false)
	private String userName;
	private String email;
	private String password;
	private String old_password;
	private String name;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserModel(Long user_id, String userName, String email, String password, String old_password, String name) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.old_password = old_password;
		this.name = name;
	}
	public UserModel() {
		
		// TODO Auto-generated constructor stub
	}
	
	 //@ManyToMany(mappedBy = "roles")
	  //  private List < Role > role;
	
	
	

}
