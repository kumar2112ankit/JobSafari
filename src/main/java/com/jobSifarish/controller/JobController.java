/**
 * 
 */
package com.jobSifarish.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobSifarish.DO.JobDiscriptionDO;
import com.jobSifarish.service.JobService;

/**
 * @author Kumar
 *
 * 
 *         Aug 24, 2020
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class JobController {

	@Autowired
	private JobService jobService;

	@PostMapping("/postJob")
	public ResponseEntity<String> postJob(HttpServletRequest request, @RequestBody JobDiscriptionDO job) {
		return jobService.postJob(job, request);
	}

	@PostMapping("/getPostedJobByUser")
	public ResponseEntity<String> getPostedJobByUser(HttpServletRequest httpRequest) {
		return jobService.getPostedJobByUser(httpRequest);
	}

	@PostMapping("/searchJobByLocationTitle")
	public ResponseEntity<String> jobSearch(@RequestBody String requestBody) {
		return jobService.searchJobByLocationTitle(requestBody);
	}

	@PostMapping("/getAllJobs")
	public ResponseEntity<String> getJobsRecord() {
		return jobService.getAllJobRecords();
	}
}
