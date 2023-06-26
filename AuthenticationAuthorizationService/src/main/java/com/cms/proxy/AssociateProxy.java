package com.cms.proxy;

import com.cms.model.Associate;

public interface AssociateProxy {

    /**
     * Create a new associate.
     *
     * @param associate The associate object to be created.
     * @return The created associate object.
     */
    Associate createAssociate(Associate associate);

    /**
     * Update an existing associate.
     *
     * @param associate The associate object to be updated.
     * @return The updated associate object.
     */
    Associate updateAssociate(Associate associate);

    /**
     * Get an associate by its ID.
     *
     * @param associateId The ID of the associate.
     * @return The associate object.
     */
    Associate getAssociateById(String associateId);

    /**
     * Delete an associate by its ID.
     *
     * @param associateId The ID of the associate.
     */
    void deleteAssociateById(String associateId);
}
