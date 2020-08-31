/**
 * 
 */
package com.jobSifarish.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kumar
 *

	Aug 25, 2020
 */
@Entity
@Table
public class JobModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private String location;
	private String recuraterNmae;
	private String technology;
	private String jobPostDate;
	private String lastDateOfJoining;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getRecuraterNmae() {
		return recuraterNmae;
	}
	public void setRecuraterNmae(String recuraterNmae) {
		this.recuraterNmae = recuraterNmae;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getJobPostDate() {
		return jobPostDate;
	}
	public void setJobPostDate(String jobPostDate) {
		this.jobPostDate = jobPostDate;
	}
	public String getLastDateOfJoining() {
		return lastDateOfJoining;
	}
	public void setLastDateOfJoining(String lastDateOfJoining) {
		this.lastDateOfJoining = lastDateOfJoining;
	}
	public JobModel(Integer id, String title, String description, String location, String recuraterNmae,
			String technology, String jobPostDate, String lastDateOfJoining) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.recuraterNmae = recuraterNmae;
		this.technology = technology;
		this.jobPostDate = jobPostDate;
		this.lastDateOfJoining = lastDateOfJoining;
	}
	public JobModel() {
		
	}
	
	
	
}
