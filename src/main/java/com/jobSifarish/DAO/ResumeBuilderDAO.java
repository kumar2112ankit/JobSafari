package com.jobSifarish.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * 
 * @author Manish (25/August/2020)
 * 
 */

import com.jobSifarish.model.EducationDetails;

@Repository
public interface ResumeBuilderDAO extends JpaRepository<EducationDetails, Long> {
	EducationDetails findByEducationId(Long educationId);

	@Query("FROM EducationDetails ed WHERE ed.userModel in (select userId from UserModel where userName =?1)")
	EducationDetails findByUserName(String userName);
}
