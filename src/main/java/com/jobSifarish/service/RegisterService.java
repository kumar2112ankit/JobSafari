package com.jobSifarish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.RegisterDao;
import com.jobSifarish.model.UserModel;

@Service
public class RegisterService {
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserModel registerUser(UserModel userModel) throws Exception {
		if (registerDao.findByUserName(userModel.getUserName()) != null) {
			throw new Exception("User Name Already Available");
		}
		String password=userModel.getPassword();
		userModel.setPassword(passwordEncoder.encode(password));
		return registerDao.save(userModel);
	}

	public Boolean validateUserName(String userName) throws Exception {

		JSONObject jsonObject = new JSONObject(userName);

		Boolean isVailable = false;

		UserModel userModel = registerDao.findByUserName(jsonObject.optString("user_name"));
		if (userModel != null) {
			isVailable = true;
		}
		return isVailable;
	}

}
