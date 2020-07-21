package com.jobSafari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RegisterController {
	@GetMapping(value = "/api/good")
	public String postUser() {
		System.out.println("TestController.postUser()");
		return "hello";
	}
}
