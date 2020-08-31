package com.jobSifarish.DAO;

import com.jobSifarish.model.EducationDetails;

public class ResumeBuilderDAO {

	public EducationDetails registerEducationalDetails(EducationDetails educationDetails,
			ResumeBuilderInterface resumeBuilderInterface) {
		return resumeBuilderInterface.save(educationDetails);
	}

//	public ProfessionalDetails registerProfessionalDetailsDetails(ProfessionalDetails professionalDetails) {
//		return resumeBuilderDAO.save(professionalDetails);
//	}
}
