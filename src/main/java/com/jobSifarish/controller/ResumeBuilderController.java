package com.jobSifarish.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobSifarish.service.ResumeBuilderService;

/*
 * 
 * @author Manish (25/August/2020)
 * 
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class ResumeBuilderController {

	@Autowired
	private ResumeBuilderService resumeBuilderService;

	@PostMapping(value = "/updateEducationDetails")
	public ResponseEntity<String> registerEducationalDetail(@RequestBody String educationDetails,
			HttpServletRequest request) {

		return resumeBuilderService.registerEducationalDetails(request, educationDetails);
	}

	@PostMapping(value = "/getEducationDetails")
	public ResponseEntity<String> getEducationalDetail(HttpServletRequest request) {
		return resumeBuilderService.getEducationalDetails(request);
	}

	@GetMapping(value = "/hiapi")
	public String getEducationalDetailGet(HttpServletRequest request) {
		return "Hello";
	}
}
