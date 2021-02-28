package com.jobSifarish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobSifarish.DO.UserDO;
import com.jobSifarish.DO.UserDetailAuthorization;
import com.jobSifarish.constants.Constants;
import com.jobSifarish.service.MyUserDetailService;
import com.jobSifarish.service.UserService;
import com.jobSifarish.util.JwtResponce;
import com.jobSifarish.util.JwtUtils;

@RestController
@RequestMapping(value = "/api")
public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailService userDetailService;

	@Autowired
	private JwtUtils jwtUtil;

	@Autowired
	private UserService registerService;

	@PostMapping(value = "/signup")
	public ResponseEntity<String> registerUser(@RequestBody UserDO registerUser) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		try {
			if (registerService.registerUser(registerUser) != null) {
				jsonObject.put(Constants.MESSAGE, "User Registered SuccessFully");
			} else {
				jsonObject.put(Constants.MESSAGE, "User Not Registered");
			}
		} catch (JSONException jsonException) {
			jsonObject.put(Constants.E_MESSAGE, jsonException.getMessage());
			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			jsonObject.put(Constants.E_MESSAGE, e.getMessage());
			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationTokken(@RequestBody UserDetailAuthorization user) throws Exception {
		String jwt = "";
		JSONObject outputJson = new JSONObject();
		UserDetails userDetails = null;
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailAddress(), user.getPassword()));

			userDetails = userDetailService.loadUserByUsername(user.getEmailAddress());
			jwt = jwtUtil.generateToken(userDetails);
		} catch (UsernameNotFoundException usernameNotFoundException) {
			outputJson.put(Constants.E_MESSAGE, "User Name Available");
			return new ResponseEntity<String>(outputJson.toString(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			outputJson.put(Constants.E_MESSAGE, e.getMessage());
			return new ResponseEntity<String>(outputJson.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(new JwtResponce(jwt));
	}

	@PostMapping(value = "/validateEmail")
	public ResponseEntity<String> validatUserName(@RequestBody String userName) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		try {
			String isAvailable = registerService.validateUserName(userName);

			jsonObject.put(Constants.RESPONSE, isAvailable);
		} catch (JSONException jsonException) {
			jsonObject.put(Constants.E_MESSAGE, jsonException.getMessage());
			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			jsonObject.put(Constants.E_MESSAGE, e.getMessage());
			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
	}

}