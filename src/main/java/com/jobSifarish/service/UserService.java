package com.jobSifarish.service;

import javax.servlet.http.HttpServletRequest;

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
import com.jobSifarish.util.CommonUtils;

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

		if (!CommonUtils.validateMobileNumber(userModel.getMobileNumber())) {
			throw new Exception("Wrong mobile no format");
		}

		if (!CommonUtils.validateEmailFormat(userModel.getEmailAddress())) {
			throw new Exception("Wrong Email Id Format");
		}
		String password = userModel.getPassword();
		userModel.setPassword(passwordEncoder.encode(password));
		return userDAO.save(userModel);
	}

	public Boolean validateUserName(String userName) throws Exception {

		JSONObject jsonObject = new JSONObject(userName);

		Boolean isVailable = false;

		UserDO userModel = userDAO.findByEmailAddress(jsonObject.optString("emailAddress"));
		if (userModel != null) {
			isVailable = true;
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
			JSONObject dataObject = createJsonForUser(userModel);

			jsonObject.put(Constants.DATA, dataObject);
			jsonObject.put(Constants.MESSAGE, "User Details Recieved");
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

	private JSONObject createJsonForUser(UserDO userModel) throws Exception {

		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(Constants.FIRST_NAME, userModel.getFirstName());
			jsonObject.put(Constants.MIDDLE_NAME, userModel.getMiddleName());
			jsonObject.put(Constants.LAST_NAME, userModel.getLastName());
			jsonObject.put(Constants.EMAIL_ADDRESS, userModel.getEmailAddress());
			jsonObject.put(Constants.MOBILE_NUMBER, userModel.getMobileNumber());
			jsonObject.put(Constants.CITY, userModel.getCity());
			jsonObject.put(Constants.STATE, userModel.getState());
			jsonObject.put(Constants.COUNTRY, userModel.getCountry());
			jsonObject.put(Constants.SKILL_SET, userModel.getSkillSet());
			jsonObject.put(Constants.DOB, userModel.getDob());
			jsonObject.put(Constants.GENDER, userModel.getGender());
			jsonObject.put(Constants.ADDRESS, userModel.getAddress());
			jsonObject.put(Constants.PROFILE_IMAGE_URL, userModel.getProfileImageUrl());

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return jsonObject;
	}

	public ResponseEntity<String> updateUser(UserDO userModel, HttpServletRequest request) throws Exception {

		JSONObject jsonObject = new JSONObject();

		try {
			UserDO userDO = userDAO.findByEmailAddress(request.getUserPrincipal().getName());
			if (userDO == null) {
				throw new Exception("User Not Available");
			}

			userModel.setUserId(userDO.getUserId());
			userModel.setPassword(userDO.getPassword());
			userModel.setOldPassword(userDO.getOldPassword());
			userModel.setEmailAddress(userDO.getEmailAddress());
			UserDO updatedUserDO = userDAO.save(userModel);

			JSONObject dataObject = new JSONObject();

			jsonObject.put(Constants.DATA, dataObject);
			jsonObject.put(Constants.STATUS, HttpStatus.OK);
			if (updatedUserDO != null) {
				dataObject.put(Constants.MESSAGE, "User Details Updated SuccessFully");
			} else {
				dataObject.put(Constants.MESSAGE, "User Not Registered");
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
