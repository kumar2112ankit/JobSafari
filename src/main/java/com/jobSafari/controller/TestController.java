package com.jobSafari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobSafari.model.UserDetailsAuthanticion;
import com.jobSafari.service.MyUserDetailService;
import com.jobSafari.util.JwtResponce;
import com.jobSafari.util.JwtUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api")
public class TestController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailService userDetailService;

	@Autowired
	private JwtUtils jwtUtil;

	@GetMapping(value = "/hi")
	public String postUser() {
		System.out.println("TestController.postUser()");
		return "hello";
	}

	@PostMapping(value = "/by")

	public String postUser1() {
		return "hello";
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationTokken(@RequestBody UserDetailsAuthanticion user) throws Exception {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		
	final UserDetails userDetails=userDetailService.loadUserByUsername(user.getUserName());
	final String jwt=jwtUtil.generateToken(userDetails)	;
	return ResponseEntity.ok(new JwtResponce(jwt));
	}

	
}
