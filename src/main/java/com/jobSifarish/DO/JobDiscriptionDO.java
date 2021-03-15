/**
 * 
 */
package com.jobSifarish.DO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Kumar
 *
 * 
 *         Aug 25, 2020
 */
@Entity
@Table
public class JobDiscriptionDO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String jobTitle;
	private String role;
	private String companyName;
	private String description;
	private String location;
	private String skillSet;
	private Date postDate;
	private String joiningType;
	private String offerPackage;
	private String experiencedRequired;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserDO userDO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getJoiningType() {
		return joiningType;
	}

	public void setJoiningType(String joiningType) {
		this.joiningType = joiningType;
	}

	public String getOfferPackage() {
		return offerPackage;
	}

	public void setOfferPackage(String offerPackage) {
		this.offerPackage = offerPackage;
	}

	public String getExperiencedRequired() {
		return experiencedRequired;
	}

	public void setExperiencedRequired(String experiencedRequired) {
		this.experiencedRequired = experiencedRequired;
	}

	public UserDO getUserDO() {
		return userDO;
	}

	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}

	public JobDiscriptionDO() {

	}

	public JobDiscriptionDO(Integer id, String jobTitle, String role, String companyName, String description,
			String location, String skillSet, Date postDate, String joiningType, String offerPackage,
			String experiencedRequired, UserDO userDO) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.role = role;
		this.companyName = companyName;
		this.description = description;
		this.location = location;
		this.skillSet = skillSet;
		this.postDate = postDate;
		this.joiningType = joiningType;
		this.offerPackage = offerPackage;
		this.experiencedRequired = experiencedRequired;
		this.userDO = userDO;
	}

}
