package com.jobSifarish.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobSifarish.DO.EducationDetails;

@Repository
public interface ResumeBuilderDAO extends JpaRepository<EducationDetails, Long> {
	EducationDetails findByEducationId(Long educationId);

	@Query("FROM EducationDetails ed WHERE ed.userDO in (select emailAddress from UserDO where emailAddress =?1)")
	EducationDetails findByEmailAddress(String userName);
}
