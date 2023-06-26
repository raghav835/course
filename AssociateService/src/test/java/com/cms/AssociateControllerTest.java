package com.cms;

import com.cms.controller.AssociateController;
import com.cms.model.Associate;
import com.cms.service.AssociateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AssociateControllerTest {

    @Mock
    private AssociateService associateService;

    @InjectMocks
    private AssociateController associateController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test115RestApiCallForViewByAssociateId() {
        int associateId = 115;
        Associate associate = new Associate();
        associate.setId(associateId);
        when(associateService.getAssociateById(associateId)).thenReturn(associate);

        ResponseEntity<Associate> response = associateController.viewByAssociateId(associateId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(associate, response.getBody());
        verify(associateService, times(1)).getAssociateById(associateId);
    }

    @Test
    public void test116RestApiCallForUpdateAssociate() {
        int associateId = 116;
        String associateAddress = "New Address";

        ResponseEntity<Void> response = associateController.updateAssociate(associateId, associateAddress);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(associateService, times(1)).updateAssociate(associateId, associateAddress);
    }

    @Test
    public void test117RestApiCallForAddAssociate() {
        Associate associate = new Associate();

        ResponseEntity<Void> response = associateController.addAssociate(associate);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(associateService, times(1)).addAssociate(associate);
    }

    @Test
    public void test115RestApiCallForViewByAssociateIdForInvalidToken() {
        int associateId = 115;
        String invalidToken = "invalid-token";

        ResponseEntity<Associate> response = associateController.viewByAssociateId(associateId, invalidToken);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        verify(associateService, never()).getAssociateById(associateId);
    }

    @Test
    public void test115RestApiCallForViewByAssociateIdForInvalidId() {
        int invalidId = -1;

        ResponseEntity<Associate> response = associateController.viewByAssociateId(invalidId);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(associateService, never()).getAssociateById(invalidId);
    }

    @Test
    public void test116RestApiCallForUpdateAssociateForInvalidToken() {
        int associateId = 116;
        String associateAddress = "New Address";
        String invalidToken = "invalid-token";

        ResponseEntity<Void> response = associateController.updateAssociate(associateId, associateAddress, invalidToken);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        verify(associateService, never()).updateAssociate(associateId, associateAddress);
    }

    @Test
    public void test116RestApiCallForUpdateAssociateForInvalidId() {
        int invalidId = -1;
        String associateAddress = "New Address";

        ResponseEntity<Void> response = associateController.updateAssociate(invalidId, associateAddress);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(associateService, never()).updateAssociate(invalidId, associateAddress);
    }

    @Test
    public void test117RestApiCallForAddAssociateForInvalidToken() {
        Associate associate = new Associate();
        String invalidToken = "invalid-token";

        ResponseEntity<Void> response = associateController.addAssociate(associate, invalidToken);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        verify(associateService, never()).addAssociate(associate);
    }

}
