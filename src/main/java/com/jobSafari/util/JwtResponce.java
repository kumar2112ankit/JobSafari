package com.jobSafari.util;

public class JwtResponce {
	private String jwt;

	public JwtResponce(String jwt) {
		
		this.jwt = jwt;
	}

	public JwtResponce() {
			}

	public String getJwt() {
		return jwt;
	}
	
 
}
