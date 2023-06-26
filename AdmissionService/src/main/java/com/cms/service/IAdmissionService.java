package com.cms.service;

import java.util.List;

import com.cms.exception.AdmissionInvalidException;
import com.cms.model.Admission;

public interface IAdmissionService {
	
	Admission registerAssociateForCourse(Admission admission) throws AdmissionInvalidException;
	
	int calculateFees(String associateId) throws AdmissionInvalidException;
	
	Admission addFeedback(Long regNo, String feedback, float feedbackRating) throws AdmissionInvalidException;
	
	List<String> highestFeeForTheRegisteredCourse(String associateId) throws AdmissionInvalidException;
	
	List<String> viewFeedbackByCourseId(String courseId) throws AdmissionInvalidException;
	
	boolean deactivateAdmission(String courseId) throws AdmissionInvalidException;
	
	boolean makePayment(int registrationId) throws AdmissionInvalidException;
	
	List<Admission> viewAll();
}
