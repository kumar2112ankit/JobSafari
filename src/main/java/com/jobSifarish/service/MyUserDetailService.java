package com.jobSifarish.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.RegisterDao;
import com.jobSifarish.model.UserModel;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private RegisterDao registerDao;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserModel user = registerDao.findByUserName(username);
		if (user != null) {
			return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Invalid User Details");
		}
	}

}
