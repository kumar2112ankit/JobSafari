package com.jobSifarish.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.UserDAO;
import com.jobSifarish.DO.UserDO;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private UserDAO registerDAO;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserDO user = registerDAO.findByEmailAddress(username);
		if (user != null) {
			return new User(user.getEmailAddress(), user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Invalid User Details");
		}
	}
}
