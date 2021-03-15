/**
 * 
 */
package com.jobSifarish.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jobSifarish.DAO.JobDAO;
import com.jobSifarish.DAO.UserDAO;
import com.jobSifarish.DO.JobDiscriptionDO;
import com.jobSifarish.DO.UserDO;
import com.jobSifarish.constants.Constants;
import com.jobSifarish.util.CommonUtils;

/**
 * @author Kumar
 *
 * 
 *         Aug 25, 2020
 */
@Service
public class JobService {

	@Autowired
	private UserDAO registerDao;

	@Autowired
	private JobDAO jobDAO;

	public ResponseEntity<String> postJob(JobDiscriptionDO jobDiscriptionDO, HttpServletRequest request) {

		JSONObject outputObject = new JSONObject();

		try {

			UserDO userDO = registerDao.findByEmailAddress(request.getUserPrincipal().getName());

			jobDiscriptionDO.setUserDO(userDO);
			jobDiscriptionDO.setPostDate(new Date());
			JSONObject dataObject = new JSONObject();
			if (jobDAO.save(jobDiscriptionDO) != null) {

				dataObject.put(Constants.MESSAGE, "Job Posted Succesfully");

			} else {
				dataObject.put(Constants.MESSAGE, "Job Posting Failed");
			}
			outputObject.put(Constants.DATA, dataObject);
			outputObject.put(Constants.STATUS, HttpStatus.OK);

		} catch (JSONException exception) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputObject, exception);
		} catch (Exception exception) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputObject, exception);
		}

		return new ResponseEntity<String>(outputObject.toString(), HttpStatus.OK);
	}

	public ResponseEntity<String> searchJobByLocationTitle(String filterParameter) {

		JSONObject outputJsonObject = new JSONObject();

		try {

			JSONObject requestJsonObject = new JSONObject(filterParameter);
			List<JobDiscriptionDO> discriptionDOs = jobDAO.searchJobByLocationTitle(
					requestJsonObject.optString("searchKey"), requestJsonObject.optString("searchKey"));

			JSONArray jsonArray = getJobDetailsInJson(discriptionDOs);

			outputJsonObject.put(Constants.DATA, jsonArray);
			outputJsonObject.put(Constants.MESSAGE, "Jobs Details fetched succesfully");
			outputJsonObject.put(Constants.STATUS, HttpStatus.OK);
		} catch (JSONException exception) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputJsonObject, exception);
		} catch (Exception exception) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputJsonObject, exception);
		}

		return new ResponseEntity<String>(outputJsonObject.toString(), HttpStatus.OK);
	}

	public ResponseEntity<String> getPostedJobByUser(HttpServletRequest httpRequest) {
		JSONObject outputObject = new JSONObject();
		try {

			List<JobDiscriptionDO> discriptionDOs = jobDAO.findByEmailAddress(httpRequest.getUserPrincipal().getName());

			JSONArray jsonArray = getJobDetailsInJson(discriptionDOs);

			outputObject.put(Constants.DATA, jsonArray);
			outputObject.put(Constants.MESSAGE, "Jobs Details fetched succesfully");
			outputObject.put(Constants.STATUS, HttpStatus.OK);
		} catch (JSONException exception) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputObject, exception);
		} catch (Exception exception) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputObject, exception);
		}
		return new ResponseEntity<String>(outputObject.toString(), HttpStatus.OK);
	}

	private JSONArray getJobDetailsInJson(List<JobDiscriptionDO> discriptionDOs) throws JSONException {
		JSONArray jsonArray = new JSONArray();
		for (JobDiscriptionDO discriptionDO : discriptionDOs) {
			JSONObject outputJson = new JSONObject();

			outputJson.put(Constants.JOB_TITLE, discriptionDO.getJobTitle());
			outputJson.put(Constants.ROLE, discriptionDO.getRole());
			outputJson.put(Constants.COMPANY_NAME, discriptionDO.getCompanyName());
			outputJson.put(Constants.DESCRIPTION, discriptionDO.getDescription());
			outputJson.put(Constants.LOCATION, discriptionDO.getLocation());
			outputJson.put(Constants.SKILL_SET, discriptionDO.getSkillSet());
			outputJson.put(Constants.JOINING_TYPE, discriptionDO.getJoiningType());
			outputJson.put(Constants.OFFER_PACKAGE, discriptionDO.getOfferPackage());
			outputJson.put(Constants.EXPERIENCED_REQUIRED, discriptionDO.getExperiencedRequired());
			outputJson.put(Constants.DATE, discriptionDO.getPostDate());
			outputJson.put(Constants.POSTED_BY, discriptionDO.getUserDO().getFirstName());

			jsonArray.put(outputJson);
		}
		return jsonArray;
	}

	public ResponseEntity<String> getAllJobRecords() {

		JSONObject outputJsonObject = new JSONObject();

		try {

			List<JobDiscriptionDO> discriptionDOs = jobDAO.getAllJobs();

			JSONArray jsonArray = getJobDetailsInJson(discriptionDOs);

			outputJsonObject.put(Constants.DATA, jsonArray);
			outputJsonObject.put(Constants.MESSAGE, "Jobs Details fetched succesfully");
			outputJsonObject.put(Constants.STATUS, HttpStatus.OK);
		} catch (JSONException exception) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputJsonObject, exception);
		} catch (Exception exception) {
			return CommonUtils.getResponseJsonAndHttpStatusCode(outputJsonObject, exception);
		}

		return new ResponseEntity<String>(outputJsonObject.toString(), HttpStatus.OK);
	}

}
