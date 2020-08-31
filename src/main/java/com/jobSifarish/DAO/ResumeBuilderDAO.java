package com.jobSifarish.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobSifarish.model.EducationDetails;

@Repository
public interface ResumeBuilderDAO extends JpaRepository<EducationDetails, Long> {
	EducationDetails findByEducationId(Long educationId);
}
