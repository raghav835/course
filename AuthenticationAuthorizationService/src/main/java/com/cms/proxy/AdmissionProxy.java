package com.cms.proxy;

import com.cms.model.Admission;

public interface AdmissionProxy {

    /**
     * Create a new admission.
     *
     * @param admission The admission object to be created.
     * @return The created admission object.
     */
    Admission createAdmission(Admission admission);

    /**
     * Update an existing admission.
     *
     * @param admission The admission object to be updated.
     * @return The updated admission object.
     */
    Admission updateAdmission(Admission admission);

    /**
     * Get an admission by its ID.
     *
     * @param admissionId The ID of the admission.
     * @return The admission object.
     */
    Admission getAdmissionById(String admissionId);

    /**
     * Delete an admission by its ID.
     *
     * @param admissionId The ID of the admission.
     */
    void deleteAdmissionById(String admissionId);
}
