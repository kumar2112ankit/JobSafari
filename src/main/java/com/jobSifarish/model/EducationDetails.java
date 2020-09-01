package com.jobSifarish.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	private String seniorSecSchoolName;
	private String seniorSecSchoolSession;
	private String seniorSecSchoolMarks;
	private String seniorSecSchoolUniversity;
	private String seniorSecSchoolLocation;

	private String higSeniorSecSchoolName;
	private String higSeniorSecSchoolSession;
	private String higSeniorSecSchoolMarks;
	private String higSeniorSecSchoolUniversity;
	private String higSeniorSecSchoolLocation;

	private String ugCollegeName;
	private String ugCollegeSession;
	private String ugCollegeMarks;
	private String ugCollegeUniversity;
	private String ugCollegeLocation;
	private String ugStream;

	private String pgCollegeName;
	private String pgCollegeSession;
	private String pgCollegeMarks;
	private String pgCollegeUniversity;
	private String pgCollegeLocation;
	private String pgStream;

	@OneToOne
	@JoinColumn(name = "user_id", unique = true)
	private UserModel userModel;

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public Long getEducationId() {
		return educationId;
	}

	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}

	public String getSeniorSecSchoolName() {
		return seniorSecSchoolName;
	}

	public void setSeniorSecSchoolName(String seniorSecSchoolName) {
		this.seniorSecSchoolName = seniorSecSchoolName;
	}

	public String getSeniorSecSchoolSession() {
		return seniorSecSchoolSession;
	}

	public void setSeniorSecSchoolSession(String seniorSecSchoolSession) {
		this.seniorSecSchoolSession = seniorSecSchoolSession;
	}

	public String getSeniorSecSchoolMarks() {
		return seniorSecSchoolMarks;
	}

	public void setSeniorSecSchoolMarks(String seniorSecSchoolMarks) {
		this.seniorSecSchoolMarks = seniorSecSchoolMarks;
	}

	public String getSeniorSecSchoolUniversity() {
		return seniorSecSchoolUniversity;
	}

	public void setSeniorSecSchoolUniversity(String seniorSecSchoolUniversity) {
		this.seniorSecSchoolUniversity = seniorSecSchoolUniversity;
	}

	public String getSeniorSecSchoolLocation() {
		return seniorSecSchoolLocation;
	}

	public void setSeniorSecSchoolLocation(String seniorSecSchoolLocation) {
		this.seniorSecSchoolLocation = seniorSecSchoolLocation;
	}

	public String getHigSeniorSecSchoolName() {
		return higSeniorSecSchoolName;
	}

	public void setHigSeniorSecSchoolName(String higSeniorSecSchoolName) {
		this.higSeniorSecSchoolName = higSeniorSecSchoolName;
	}

	public String getHigSeniorSecSchoolSession() {
		return higSeniorSecSchoolSession;
	}

	public void setHigSeniorSecSchoolSession(String higSeniorSecSchoolSession) {
		this.higSeniorSecSchoolSession = higSeniorSecSchoolSession;
	}

	public String getHigSeniorSecSchoolMarks() {
		return higSeniorSecSchoolMarks;
	}

	public void setHigSeniorSecSchoolMarks(String higSeniorSecSchoolMarks) {
		this.higSeniorSecSchoolMarks = higSeniorSecSchoolMarks;
	}

	public String getHigSeniorSecSchoolUniversity() {
		return higSeniorSecSchoolUniversity;
	}

	public void setHigSeniorSecSchoolUniversity(String higSeniorSecSchoolUniversity) {
		this.higSeniorSecSchoolUniversity = higSeniorSecSchoolUniversity;
	}

	public String getHigSeniorSecSchoolLocation() {
		return higSeniorSecSchoolLocation;
	}

	public void setHigSeniorSecSchoolLocation(String higSeniorSecSchoolLocation) {
		this.higSeniorSecSchoolLocation = higSeniorSecSchoolLocation;
	}

	public String getUgCollegeName() {
		return ugCollegeName;
	}

	public void setUgCollegeName(String ugCollegeName) {
		this.ugCollegeName = ugCollegeName;
	}

	public String getUgCollegeSession() {
		return ugCollegeSession;
	}

	public void setUgCollegeSession(String ugCollegeSession) {
		this.ugCollegeSession = ugCollegeSession;
	}

	public String getUgCollegeMarks() {
		return ugCollegeMarks;
	}

	public void setUgCollegeMarks(String ugCollegeMarks) {
		this.ugCollegeMarks = ugCollegeMarks;
	}

	public String getUgCollegeUniversity() {
		return ugCollegeUniversity;
	}

	public void setUgCollegeUniversity(String ugCollegeUniversity) {
		this.ugCollegeUniversity = ugCollegeUniversity;
	}

	public String getUgCollegeLocation() {
		return ugCollegeLocation;
	}

	public void setUgCollegeLocation(String ugCollegeLocation) {
		this.ugCollegeLocation = ugCollegeLocation;
	}

	public String getUgStream() {
		return ugStream;
	}

	public void setUgStream(String ugStream) {
		this.ugStream = ugStream;
	}

	public String getPgCollegeName() {
		return pgCollegeName;
	}

	public void setPgCollegeName(String pgCollegeName) {
		this.pgCollegeName = pgCollegeName;
	}

	public String getPgCollegeSession() {
		return pgCollegeSession;
	}

	public void setPgCollegeSession(String pgCollegeSession) {
		this.pgCollegeSession = pgCollegeSession;
	}

	public String getPgCollegeMarks() {
		return pgCollegeMarks;
	}

	public void setPgCollegeMarks(String pgCollegeMarks) {
		this.pgCollegeMarks = pgCollegeMarks;
	}

	public String getPgCollegeUniversity() {
		return pgCollegeUniversity;
	}

	public void setPgCollegeUniversity(String pgCollegeUniversity) {
		this.pgCollegeUniversity = pgCollegeUniversity;
	}

	public String getPgCollegeLocation() {
		return pgCollegeLocation;
	}

	public void setPgCollegeLocation(String pgCollegeLocation) {
		this.pgCollegeLocation = pgCollegeLocation;
	}

	public String getPgStream() {
		return pgStream;
	}

	public void setPgStream(String pgStream) {
		this.pgStream = pgStream;
	}

	public EducationDetails(Long educationId,

			String seniorSecSchoolName, String seniorSecSchoolSession, String seniorSecSchoolMarks,
			String seniorSecSchoolUniversity, String seniorSecSchoolLocation,

			String higSeniorSecSchoolName, String higSeniorSecSchoolSession, String higSeniorSecSchoolMarks,
			String higSeniorSecSchoolUniversity, String higSeniorSecSchoolLocation,

			String ugCollegeName, String ugCollegeSession, String ugCollegeMarks, String ugCollegeUniversity,
			String ugCollegeLocation, String ugStream,

			String pgCollegeName, String pgCollegeSession, String pgCollegeMarks, String pgCollegeUniversity,
			String pgCollegeLocation, String pgStream) {
		super();
		this.educationId = educationId;
		this.seniorSecSchoolName = seniorSecSchoolName;
		this.seniorSecSchoolSession = seniorSecSchoolSession;
		this.seniorSecSchoolMarks = seniorSecSchoolMarks;
		this.seniorSecSchoolUniversity = seniorSecSchoolUniversity;
		this.seniorSecSchoolLocation = seniorSecSchoolLocation;
		this.higSeniorSecSchoolName = higSeniorSecSchoolName;
		this.higSeniorSecSchoolSession = higSeniorSecSchoolSession;
		this.higSeniorSecSchoolMarks = higSeniorSecSchoolMarks;
		this.higSeniorSecSchoolUniversity = higSeniorSecSchoolUniversity;
		this.higSeniorSecSchoolLocation = higSeniorSecSchoolLocation;
		this.ugCollegeName = ugCollegeName;
		this.ugCollegeSession = ugCollegeSession;
		this.ugCollegeMarks = ugCollegeMarks;
		this.ugCollegeUniversity = ugCollegeUniversity;
		this.ugCollegeLocation = ugCollegeLocation;
		this.ugStream = ugStream;
		this.pgCollegeName = pgCollegeName;
		this.pgCollegeSession = pgCollegeSession;
		this.pgCollegeMarks = pgCollegeMarks;
		this.pgCollegeUniversity = pgCollegeUniversity;
		this.pgCollegeLocation = pgCollegeLocation;
		this.pgStream = pgStream;
	}

	public EducationDetails() {

	}
}
