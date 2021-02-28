/**
 * 
 */
package com.jobSifarish.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobSifarish.DO.JobModel;

/**
 * @author Kumar
 *

	Aug 25, 2020
 */
@Repository
public interface JobDAO extends JpaRepository<JobModel, Integer> {

	/**
	 * @param jobDao
	 * @param location
	 * @param technology
	 * @param date
	 * @return
	 */
	@Query("SELECT u FROM JobModel u WHERE u.title = ?1 or u.location = ?2 or u.technology = ?3 or u.jobPostDate = ?4")
	List<JobModel> searchJob(String name, String location, String technology, String date);

}