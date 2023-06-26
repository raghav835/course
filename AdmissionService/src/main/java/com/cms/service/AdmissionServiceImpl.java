package com.cms.service;

import java.util.List;

import com.cms.exception.AdmissionInvalidException;
import com.cms.model.Admission;

public class AdmissionServiceImpl implements IAdmissionService {

	@Override
	public Admission registerAssociateForCourse(Admission admission) throws AdmissionInvalidException {
		// Implement the logic to register an associate for a course
		// Throw AdmissionInvalidException if the registration is invalid or fails
	}

	@Override
	public int calculateFees(String associateId) throws AdmissionInvalidException {
		// Implement the logic to calculate fees for an associate
		// Throw AdmissionInvalidException if the associate is not found or the calculation fails
	}

	@Override
	public Admission addFeedback(Long regNo, String feedback, float feedbackRating) throws AdmissionInvalidException {
		// Implement the logic to add feedback for a registration
		// Throw AdmissionInvalidException if the registration is not found or the feedback addition fails
	}

	@Override
	public List<String> highestFeeForTheRegisteredCourse(String associateId) throws AdmissionInvalidException {
		// Implement the logic to retrieve the course(s) with the highest fee for a given associate
		// Throw AdmissionInvalidException if the associate is not found or the retrieval fails
	}

	@Override
	public List<String> viewFeedbackByCourseId(String courseId) throws AdmissionInvalidException {
		// Implement the logic to retrieve feedback for a given course
		// Throw AdmissionInvalidException if the course is not found or the retrieval fails
	}

	@Override
	public boolean deactivateAdmission(String courseId) throws AdmissionInvalidException {
		// Implement the logic to deactivate an admission for a course
		// Throw AdmissionInvalidException if the course is not found or the deactivation fails
	}

	@Override
	public boolean makePayment(int registrationId) throws AdmissionInvalidException {
		// Implement the logic to make a payment for a registration
		// Throw AdmissionInvalidException if the registration is not found or the payment fails
	}

	@Override
	public List<Admission> viewAll() {
		// Implement the logic to retrieve all admissions
	}

}
