package com.jobSifarish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobSifarish.model.UserDetailsAuthanticion;
import com.jobSifarish.model.UserModel;
import com.jobSifarish.service.MyUserDetailService;
import com.jobSifarish.service.RegisterService;
import com.jobSifarish.util.JwtResponce;
import com.jobSifarish.util.JwtUtils;

@RestController
@RequestMapping(value = "/api")
public class TestController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailService userDetailService;

	@Autowired
	private JwtUtils jwtUtil;

	@Autowired
	private RegisterService registerService;

	@PostMapping(value = "/signup")
	public ResponseEntity<String> registerUser(@RequestBody UserModel registerUser) {

		if (registerService.registerUser(registerUser) != null) {
			return new ResponseEntity<>("User Registered", HttpStatus.OK);
		}
		return new ResponseEntity<>("User Not Registered", HttpStatus.BAD_REQUEST);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationTokken(@RequestBody UserDetailsAuthanticion user) throws Exception {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));

		final UserDetails userDetails = userDetailService.loadUserByUsername(user.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponce(jwt));
	}

}
