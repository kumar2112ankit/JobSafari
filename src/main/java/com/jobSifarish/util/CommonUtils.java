package com.jobSifarish.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.jobSifarish.constants.Constants;

public class CommonUtils {

	public static ResponseEntity<String> getResponseJsonAndHttpStatusCode(JSONObject outputJson, Exception e) {
		if (outputJson.length() == 0) {
			try {
				outputJson.put(Constants.E_MESSAGE, e.getMessage());
			} catch (Exception ex) {
				e.printStackTrace();
			}
			return new ResponseEntity<String>(outputJson.toString(), HttpStatus.INTERNAL_SERVER_ERROR);

		} else {
			return new ResponseEntity<String>(outputJson.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	public static boolean validateEmailFormat(String email) {
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean validateMobileNumber(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			return false;
		}
		if (mobile.matches("[0-9]+")) {
			return true;
		} else {
			return false;
		}
	}

}
