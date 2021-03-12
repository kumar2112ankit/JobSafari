package com.jobSifarish.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobSifarish.DO.EducationDetails;

/*
 * @Author Manish
  @ 12/March/2021
 */

@Repository
public interface ResumeBuilderDAO extends JpaRepository<EducationDetails, Long> {
	EducationDetails findByEducationId(Long educationId);

	@Query("FROM EducationDetails ed WHERE ed.userDO in (select ud from UserDO ud where emailAddress =?1)")
	List<EducationDetails> findByEmailAddress(String userName);
}
