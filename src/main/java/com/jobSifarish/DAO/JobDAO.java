/**
 * 
 */
package com.jobSifarish.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobSifarish.DO.JobDiscriptionDO;

/**
 * @author Kumar
 *
 * 
 *         Aug 25, 2020
 */
@Repository
public interface JobDAO extends JpaRepository<JobDiscriptionDO, Integer> {

	/**
	 * @param jobDao
	 * @param location
	 * @param technology
	 * @param date
	 * @return
	 */
	@Query("SELECT u FROM JobDiscriptionDO u WHERE u.jobTitle like  %:titleName%   or  u.location like  %:location%")
	List<JobDiscriptionDO> searchJobByLocationTitle(String titleName, String location);

	@Query("FROM JobDiscriptionDO jd WHERE jd.userDO in (select ud from UserDO ud where emailAddress =?1)")
	List<JobDiscriptionDO> findByEmailAddress(String name);

	@Query("FROM JobDiscriptionDO jd ")
	List<JobDiscriptionDO> getAllJobs();

}
