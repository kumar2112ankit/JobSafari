package com.jobSafari.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobSafari.dao.RegisterDao;
import com.jobSafari.model.UserModel;
import com.jobSafari.securityConfiguration.MyUserDetail;
@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private RegisterDao registerDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user=registerDao.findByUserName(username);
		if(user!=null) {
		return new User(user.getUser_name(),user.getPassword(), new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("user not aveliable");
		}
		}

}
