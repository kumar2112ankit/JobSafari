package com.jobSafari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobSafari.dao.RegisterDao;
import com.jobSafari.model.UserModel;

@Service
public class RegisterService {
	@Autowired
	private RegisterDao registerDao;
	
	public UserModel registerUser(UserModel userModel) {
		return registerDao.save(userModel);
	}

}
