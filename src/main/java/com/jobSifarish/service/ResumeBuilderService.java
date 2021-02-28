package com.jobSifarish.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.UserDAO;
import com.jobSifarish.DAO.ResumeBuilderDAO;
import com.jobSifarish.DO.EducationDetails;
import com.jobSifarish.DO.UserDO;
import com.jobSifarish.constants.Constants;
import com.jobSifarish.util.CommonUtils;

/*
 * 
 * @author Manish (25/August/2020)
 * 
 */

@Service
public class ResumeBuilderService {
	@Autowired
	private UserDAO registerDao;

	@Autowired
	private ResumeBuilderDAO resumeBuilderDAO;

	public ResponseEntity<String> registerEducationalDetails(HttpServletRequest request,
			EducationDetails educationDetails) {

		JSONObject outputJson = new JSONObject();
		try {
			UserDO userDO = registerDao.findByEmailAddress(request.getUserPrincipal().getName());
			educationDetails.setUserDO(userDO);

			EducationDetails isEdDetailsAvl = resumeBuilderDAO.findByEmailAddress(request.getUserPrincipal().getName());

			if (isEdDetailsAvl == null) {
				resumeBuilderDAO.save(educationDetails);
				outputJson.put(Constants.MESSAGE, "Educational Details Saved SuccessFully");
			} else {
				educationDetails.setEducationId(isEdDetailsAvl.getEducationId());
				resumeBuilderDAO.save(educationDetails);
				outputJson.put(Constants.MESSAGE, "Educational Details Updated SuccessFully");
			}
		} catch (Exception e) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputJson, e);
		}
		return new ResponseEntity<String>(outputJson.toString(), HttpStatus.OK);
	}
}
