package com.jobSafari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobSafari.model.UserDetails;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api")
public class TestController {

	@PostMapping(value = "/hello")
	public UserDetails getUser(@RequestBody UserDetails user) {
		return user;
	}

	@GetMapping(value = "/hi")

	public String postUser() {
		return "hello";
	}

	@PostMapping(value = "/hi12")

	public String postUser1() {
		return "hello";
	}
}
