package com.jobSafari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobSafari.dao.RegisterDao;
import com.jobSafari.model.UserModel;

@Service
public class RegisterService {
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserModel registerUser(UserModel userModel) {
		String password=userModel.getPassword();
		System.out.println(password);
		System.out.println(passwordEncoder.encode(password));
		userModel.setPassword(passwordEncoder.encode(password));
		return registerDao.save(userModel);
	}

}
