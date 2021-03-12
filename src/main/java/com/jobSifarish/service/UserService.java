package com.jobSifarish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.UserDAO;
import com.jobSifarish.DO.UserDO;
import com.jobSifarish.constants.Constants;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDO registerUser(UserDO userModel) throws Exception {
		if (userDAO.findByEmailAddress(userModel.getEmailAddress()) != null) {
			throw new Exception("User Name Already Available");
		}
		String password = userModel.getPassword();
		userModel.setPassword(passwordEncoder.encode(password));
		return userDAO.save(userModel);
	}

	public String validateUserName(String userName) throws Exception {

		JSONObject jsonObject = new JSONObject(userName);

		String isVailable = "Email not registered";

		UserDO userModel = userDAO.findByEmailAddress(jsonObject.optString("emailAddress"));
		if (userModel != null) {
			isVailable = "Email Already registered";
		}
		return isVailable;
	}

	public ResponseEntity<String> getUserDetails(String userName) throws Exception {

		JSONObject jsonObject = new JSONObject();
		try {
			UserDO userModel = userDAO.findByEmailAddress(userName);
			if (userModel == null) {
				throw new Exception("User Not Available");
			}
			jsonObject = createJsonForUser(userModel);
		} catch (JSONException jsonException) {
			jsonObject.put(Constants.E_MESSAGE, jsonException.getMessage());
			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			jsonObject.put(Constants.E_MESSAGE, e.getMessage());
			return new ResponseEntity<>(jsonObject.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
	}

	private JSONObject createJsonForUser(UserDO userModel) throws Exception {

		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("firstName", userModel.getFirstName());
			jsonObject.put("middleName", userModel.getMiddleName());
			jsonObject.put("lastName", userModel.getLastName());
			jsonObject.put("emailAddress", userModel.getEmailAddress());
			jsonObject.put("mobileNumber", userModel.getMobileNumber());

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return jsonObject;
	}

	public ResponseEntity<String> updateUser(UserDO userModel) throws Exception {

		JSONObject jsonObject = new JSONObject();

		try {
			UserDO userDO = userDAO.findByEmailAddress(userModel.getEmailAddress());
			if (userDO == null) {
				throw new Exception("User Not Available");
			}
			userModel.setUserId(userDO.getUserId());
			userModel.setPassword(userDO.getPassword());
			userModel.setOldPassword(userDO.getOldPassword());
			UserDO updatedUserDO = userDAO.save(userModel);

			if (updatedUserDO != null) {
				jsonObject.put(Constants.MESSAGE, "User Details Updated SuccessFully");
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
}
