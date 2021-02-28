package com.jobSifarish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.RegisterDAO;
import com.jobSifarish.DO.UserDO;

@Service
public class RegisterService {
	@Autowired
	private RegisterDAO registerDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDO registerUser(UserDO userModel) throws Exception {
		if (registerDAO.findByEmailAddress(userModel.getEmailAddress()) != null) {
			throw new Exception("User Name Already Available");
		}
		String password = userModel.getPassword();
		userModel.setPassword(passwordEncoder.encode(password));
		return registerDAO.save(userModel);
	}

	public String validateUserName(String userName) throws Exception {

		JSONObject jsonObject = new JSONObject(userName);

		String isVailable = "Email not registered";

		UserDO userModel = registerDAO.findByEmailAddress(jsonObject.optString("emailAddress"));
		if (userModel != null) {
			isVailable = "Email Already registered";
		}
		return isVailable;
	}

}
