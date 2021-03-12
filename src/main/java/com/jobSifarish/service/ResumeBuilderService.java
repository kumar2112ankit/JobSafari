package com.jobSifarish.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.ResumeBuilderDAO;
import com.jobSifarish.DAO.UserDAO;
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
			String educationDetailsString) {

		JSONObject outputJson = new JSONObject();

		try {

			List<EducationDetails> educationDetailsList = new ArrayList<EducationDetails>();
			UserDO userDO = registerDao.findByEmailAddress(request.getUserPrincipal().getName());
			Map<String, EducationDetails> availableEducationalMap = getEducationalDetailsIntoMap(
					request.getUserPrincipal().getName());
			if (educationDetailsString != null && educationDetailsString.length() > 0) {
				JSONArray educationJsonArray = new JSONArray(educationDetailsString);
				for (int jsonIndex = 0; jsonIndex < educationJsonArray.length(); jsonIndex++) {

					JSONObject educationObject = educationJsonArray.optJSONObject(jsonIndex);
					EducationDetails educationDetails = new EducationDetails();

					educationDetails.setEducationType(educationObject.optString(Constants.EDUCATION_TYPE));
					educationDetails.setSchoolName(educationObject.optString(Constants.SCHOOL_NAME));
					educationDetails.setSessionPeriod(educationObject.optString(Constants.SESSION_PERIOD));
					educationDetails.setScoredMarks(educationObject.optString(Constants.SCORED_MARKS));
					educationDetails.setTotalMarks(educationObject.optString(Constants.TOTAL_MARKS));
					educationDetails.setBoardName(educationObject.optString(Constants.BOARD_NAME));
					educationDetails.setLocation(educationObject.optString(Constants.LOCATION));

					if (availableEducationalMap.containsKey(educationObject.optString(Constants.EDUCATION_TYPE))) {

						EducationDetails details = availableEducationalMap
								.get(educationObject.optString(Constants.EDUCATION_TYPE));
						educationDetails.setEducationId(details.getEducationId());
					}
					educationDetails.setUserDO(userDO);

					educationDetailsList.add(educationDetails);
				}

			}

			resumeBuilderDAO.saveAll(educationDetailsList);
			outputJson.put(Constants.MESSAGE, "Educational Details Updated SuccessFully");
		} catch (Exception e) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputJson, e);
		}
		return new ResponseEntity<String>(outputJson.toString(), HttpStatus.OK);
	}

	private Map<String, EducationDetails> getEducationalDetailsIntoMap(String emailId) {

		Map<String, EducationDetails> educationalMap = new HashMap<String, EducationDetails>();
		List<EducationDetails> isEdDetailsAvl = resumeBuilderDAO.findByEmailAddress(emailId);

		for (EducationDetails educationDetails : isEdDetailsAvl) {
			educationalMap.put(educationDetails.getEducationType(), educationDetails);
		}
		return educationalMap;
	}

	public ResponseEntity<String> getEducationalDetails(HttpServletRequest request) {

		JSONArray jsonArray = new JSONArray();
		try {
			List<EducationDetails> educationaList = resumeBuilderDAO
					.findByEmailAddress(request.getUserPrincipal().getName());

			for (EducationDetails educationDetails : educationaList) {
				JSONObject outputJson = new JSONObject();

				outputJson.put(Constants.EDUCATION_TYPE, educationDetails.getEducationType());
				outputJson.put(Constants.SCHOOL_NAME, educationDetails.getSchoolName());
				outputJson.put(Constants.SESSION_PERIOD, educationDetails.getSessionPeriod());
				outputJson.put(Constants.SCORED_MARKS, educationDetails.getScoredMarks());
				outputJson.put(Constants.TOTAL_MARKS, educationDetails.getTotalMarks());
				outputJson.put(Constants.BOARD_NAME, educationDetails.getBoardName());
				outputJson.put(Constants.LOCATION, educationDetails.getLocation());

				jsonArray.put(outputJson);
			}
		} catch (Exception e) {
			JSONObject outputJson = new JSONObject();
			jsonArray.put(outputJson);
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputJson, e);
		}
		return new ResponseEntity<String>(jsonArray.toString(), HttpStatus.OK);
	}
}
