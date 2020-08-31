package com.jobSifarish.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.RegisterDao;
import com.jobSifarish.DAO.ResumeBuilderDAO;
import com.jobSifarish.DAO.ResumeBuilderInterface;
import com.jobSifarish.constants.Constants;
import com.jobSifarish.model.EducationDetails;
import com.jobSifarish.model.UserModel;
import com.jobSifarish.util.CommonUtils;

@Service
public class ResumeBuilderService {
	@Autowired
	private RegisterDao registerDao;

	public ResponseEntity<String> registerEducationalDetails(HttpServletRequest request,
			EducationDetails educationDetails, ResumeBuilderInterface resumeBuilderInterface) {

		JSONObject outputJson = new JSONObject();
		try {
			UserModel userModel = registerDao.findByUserName(request.getUserPrincipal().getName());
			educationDetails.setUserModel(userModel);
			ResumeBuilderDAO resumeBuilderDAO = new ResumeBuilderDAO();
			resumeBuilderDAO.registerEducationalDetails(educationDetails, resumeBuilderInterface);
			outputJson.put(Constants.MESSAGE, "Educational Details Saved SuccessFully");
		} catch (Exception e) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputJson, e);
		}
		return new ResponseEntity<String>(outputJson.toString(), HttpStatus.OK);
	}
}