package com.jobSifarish.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobSifarish.model.EducationDetails;
import com.jobSifarish.service.ResumeBuilderService;

/*
 * 
 * @author Manish (25/August/2020)
 * 
 */

@RestController
@RequestMapping(value = "/api")
public class ResumeBuilderController {

	@Autowired
	private ResumeBuilderService resumeBuilderService;

	@PostMapping(value = "/educationDetails")
	public ResponseEntity<String> registerEducationalDetail(@RequestBody EducationDetails educationDetails,
			HttpServletRequest request) {

		return resumeBuilderService.registerEducationalDetails(request, educationDetails);
	}

}
