package com.jobSifarish.DO;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * 
 * @author Manish (25/August/2020)
 * 
 */

@Table
@Entity
public class EducationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long educationId;

	private String educationType;
	private String schoolName;
	private String sessionPeriod;
	private String scoredMarks;
	private String totalMarks;
	private String boardName;
	private String location;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserDO userDO;

	public EducationDetails() {

	}


	public Long getEducationId() {
		return educationId;
	}


	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}


	public String getEducationType() {
		return educationType;
	}


	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}


	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	public String getSessionPeriod() {
		return sessionPeriod;
	}


	public void setSessionPeriod(String sessionPeriod) {
		this.sessionPeriod = sessionPeriod;
	}


	public String getScoredMarks() {
		return scoredMarks;
	}


	public void setScoredMarks(String scoredMarks) {
		this.scoredMarks = scoredMarks;
	}


	public String getTotalMarks() {
		return totalMarks;
	}


	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}


	public String getBoardName() {
		return boardName;
	}


	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public UserDO getUserDO() {
		return userDO;
	}


	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}


	public EducationDetails(Long educationId, String educationType, String schoolName, String sessionPeriod,
			String scoredMarks, String totalMarks, String boardName, String location, UserDO userDO) {
		super();
		this.educationId = educationId;
		this.educationType = educationType;
		this.schoolName = schoolName;
		this.sessionPeriod = sessionPeriod;
		this.scoredMarks = scoredMarks;
		this.totalMarks = totalMarks;
		this.boardName = boardName;
		this.location = location;
		this.userDO = userDO;
	}
}
