package com.jobSifarish.DO;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Table
@Entity
public class UserDO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotNull
	@Column(unique = true, length = 200, nullable = false)
	private String emailAddress;
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobileNumber;
	private String password;
	private String oldPassword;
	private String gender;
	private Date dob;
	private String address;
	private String city;
	private String state;
	private String country;
	private String skillSet;

	@Lob
	private byte[] profileImageUrl;

	@OneToMany(mappedBy = "userDO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EducationDetails> educationDetailList;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public byte[] getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(byte[] profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public UserDO() {

	}

	public UserDO(Long userId, String emailAddress, String firstName, String middleName, String lastName,
			String mobileNumber, String password, String oldPassword, String gender, Date dob, String address,
			String city, String state, String country, byte[] profileImageUrl) {
		super();
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.oldPassword = oldPassword;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.profileImageUrl = profileImageUrl;
	}
}
