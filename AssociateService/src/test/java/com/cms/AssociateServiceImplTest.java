package com.cms;

import com.cms.exception.AssociateInvalidException;
import com.cms.model.Associate;
import com.cms.repository.AssociateRepository;
import com.cms.service.AssociateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AssociateServiceImplTest {

    @Mock
    private AssociateRepository associateRepository;

    @InjectMocks
    private AssociateServiceImpl associateService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test118AddAssociate() {
        Associate associate = new Associate();
        associate.setId(118);

        when(associateRepository.save(associate)).thenReturn(associate);

        Associate savedAssociate = associateService.addAssociate(associate);

        assertNotNull(savedAssociate);
        assertEquals(associate.getId(), savedAssociate.getId());
        verify(associateRepository, times(1)).save(associate);
    }

    @Test
    public void test119ViewByAssociateId() {
        int associateId = 119;
        Associate associate = new Associate();
        associate.setId(associateId);

        when(associateRepository.findById(associateId)).thenReturn(Optional.of(associate));

        Associate foundAssociate = associateService.getAssociateById(associateId);

        assertNotNull(foundAssociate);
        assertEquals(associate.getId(), foundAssociate.getId());
        verify(associateRepository, times(1)).findById(associateId);
    }

    @Test
    public void test120UpdateAssociate() {
        int associateId = 120;
        String newAddress = "New Address";
        Associate associate = new Associate();
        associate.setId(associateId);

        when(associateRepository.findById(associateId)).thenReturn(Optional.of(associate));
        when(associateRepository.save(associate)).thenReturn(associate);

        associateService.updateAssociate(associateId, newAddress);

        assertEquals(newAddress, associate.getAddress());
        verify(associateRepository, times(1)).findById(associateId);
        verify(associateRepository, times(1)).save(associate);
    }

    @Test
    public void test121ViewByAssociateIdForInvalidId() {
        int invalidId = -1;

        when(associateRepository.findById(invalidId)).thenReturn(Optional.empty());

        assertThrows(AssociateInvalidException.class, () -> associateService.getAssociateById(invalidId));

        verify(associateRepository, times(1)).findById(invalidId);
    }

    @Test
    public void test120UpdateAssociateForInvalidId() {
        int invalidId = -1;
        String newAddress = "New Address";

        when(associateRepository.findById(invalidId)).thenReturn(Optional.empty());

        assertThrows(AssociateInvalidException.class, () -> associateService.updateAssociate(invalidId, newAddress));

        verify(associateRepository, times(1)).findById(invalidId);
        verify(associateRepository, never()).save(any(Associate.class));
    }
}
