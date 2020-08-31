/**
 * 
 */
package com.jobSifarish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobSifarish.model.JobModel;
import com.jobSifarish.service.JobService;

/**
 * @author Kumar
 *
 * 
 *         Aug 24, 2020
 */
@RestController
@RequestMapping(value = "/api")
public class JobController {

	@Autowired
	private JobService jobService;
	
	@PostMapping("/postJobe")
	public String postJob(@RequestBody JobModel job) {
		return jobService.postJob(job);
		
	}
	@PostMapping("/serchJobe/{title}/{location}/{technology}/{date}")
	public List<JobModel> jobSerch(@PathVariable String title,@PathVariable String location,@PathVariable String technology,@PathVariable String date) {
		return jobService.searchJob(title,location,technology,date);
		
	}

	public void RelativeJob() {

	}
}
