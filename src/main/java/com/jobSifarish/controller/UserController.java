package com.jobSifarish.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobSifarish.DO.UserDO;
import com.jobSifarish.DO.UserDetailAuthorization;
import com.jobSifarish.constants.Constants;
import com.jobSifarish.service.MyUserDetailService;
import com.jobSifarish.service.UserService;
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
	public ResponseEntity<String> createAuthenticationTokken(@RequestBody UserDetailAuthorization user)
			throws Exception {
		String jwt = "";
		JSONObject outputJson = new JSONObject();
		UserDetails userDetails = null;
		try {

			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailAddress(), user.getPassword()));

			userDetails = userDetailService.loadUserByUsername(user.getEmailAddress());
			jwt = jwtUtil.generateToken(userDetails);

			JSONObject tokenObject = new JSONObject();
			tokenObject.put(Constants.Authorization_Token, jwt);

			outputJson.put(Constants.DATA, tokenObject);
			outputJson.put(Constants.MESSAGE, "token Generated");
			outputJson.put(Constants.STATUS, HttpStatus.OK);
		} catch (UsernameNotFoundException usernameNotFoundException) {
			outputJson.put(Constants.E_MESSAGE, "Email Id not Available");
			return new ResponseEntity<String>(outputJson.toString(), HttpStatus.UNAUTHORIZED);
		} catch (SessionAuthenticationException authenticationException) {
			outputJson.put(Constants.E_MESSAGE, authenticationException.getMessage());
			return new ResponseEntity<>(outputJson.toString(), HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			outputJson.put(Constants.E_MESSAGE, e.getMessage());
			return new ResponseEntity<String>(outputJson.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(outputJson.toString(), HttpStatus.OK);
	}

	@PostMapping(value = "/validateEmail")
	public ResponseEntity<String> validatUserName(@RequestBody String userName) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		try {
			Boolean isAvailable = registerService.validateUserName(userName);

			JSONObject dataObject = new JSONObject();
			dataObject.put(Constants.IS_AVAILABLE, isAvailable);

			jsonObject.put(Constants.DATA, dataObject);
			jsonObject.put(Constants.MESSAGE, "Email Address Validated");
			jsonObject.put(Constants.STATUS, HttpStatus.OK);
		} catch (JSONException jsonException) {
			jsonObject.put(Constants.E_MESSAGE, jsonException.getMessage());
			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			jsonObject.put(Constants.E_MESSAGE, e.getMessage());
			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/getPersonalDetails")
	public ResponseEntity<String> getUserDetails(HttpServletRequest request) throws Exception {
		return registerService.getUserDetails(request.getUserPrincipal().getName());
	}

	@PostMapping(value = "/updatePersonalDetails")
	public ResponseEntity<String> updateUserDetails(@RequestBody UserDO userDO, HttpServletRequest request)
			throws Exception {
		return registerService.updateUser(userDO, request);
	}
}
