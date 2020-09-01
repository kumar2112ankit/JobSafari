/**
 * 
 */
package com.jobSifarish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.JobDao;
import com.jobSifarish.model.JobModel;

/**
 * @author Kumar
 *

	Aug 25, 2020
 */
@Service
public class JobService {
	@Autowired
	private JobDao jobDao;
	
	public String postJob(JobModel job){
		if(jobDao.save(job)!=null) {
			return "job posted succesfully";
		}
		else {
		return "job posting failed";
		}
		
	}
	
	public List<JobModel> searchJob(String name, String location, String technology, String date){
		return jobDao.searchJob(name,location,technology,date);
		
	}

}
