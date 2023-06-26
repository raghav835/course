package com.cms.repository;

import com.cms.model.Admission;

public interface AdmissionRepository {
	
	Admission findById(long admissionId);
	
	void save(Admission admission);
	
	void update(Admission admission);
	
	void delete(long admissionId);
	
	// Add more methods as per your admission-related operations
}
