package com.cms.repository;

import java.util.List;
import com.cms.model.Associate;

public interface AssociateRepository {
    void addAssociate(Associate associate);
    void updateAssociate(Associate associate);
    void deleteAssociate(int associateId);
    Associate getAssociateById(int associateId);
    List<Associate> getAllAssociates();
}
