/**
 * 
 */
package com.jobSafari.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobSafari.dao.JobDao;
import com.jobSafari.model.JobModel;

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
		System.out.println("JobService.searchJob()");
		System.out.println(jobDao.serchJobe(name,location,technology,date));
		return jobDao.serchJobe(name,location,technology,date);
		
	}

}
