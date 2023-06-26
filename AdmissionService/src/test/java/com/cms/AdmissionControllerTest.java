package com.cms;

import com.cms.controller.AdmissionController;
import com.cms.exception.AdmissionInvalidException;
import com.cms.model.Admission;
import com.cms.service.IAdmissionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AdmissionController.class)
public class AdmissionControllerTest {

    @Mock
    private IAdmissionService admissionService;

    @InjectMocks
    private AdmissionController admissionController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(admissionController).build();
    }

    @Test
    public void testHighestFeeForTheRegisteredCourseEndpoint() throws Exception {
        String associateId = "A001";
        List<String> courses = Arrays.asList("Course 1", "Course 2", "Course 3");

        when(admissionService.highestFeeForTheRegisteredCourse(associateId)).thenReturn(courses);

        mockMvc.perform(get("/highestFee/{associateId}", associateId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("Course 1"))
                .andExpect(jsonPath("$[1]").value("Course 2"))
                .andExpect(jsonPath("$[2]").value("Course 3"));

        verify(admissionService, times(1)).highestFeeForTheRegisteredCourse(associateId);
        verifyNoMoreInteractions(admissionService);
    }

    @Test
    public void testViewFeedbackByCourseIdEndpoint() throws Exception {
        String courseId = "C001";
        List<String> feedbacks = Arrays.asList("Feedback 1", "Feedback 2", "Feedback 3");

        when(admissionService.viewFeedbackByCourseId(courseId)).thenReturn(feedbacks);

        mockMvc.perform(get("/viewFeedbackByCourseId/{courseId}", courseId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("Feedback 1"))
                .andExpect(jsonPath("$[1]").value("Feedback 2"))
                .andExpect(jsonPath("$[2]").value("Feedback 3"));

        verify(admissionService, times(1)).viewFeedbackByCourseId(courseId);
        verifyNoMoreInteractions(admissionService);
    }

    @Test
    public void testCalculateFeesEndpoint() throws Exception {
        String associateId = "A001";
        int fees = 5000;

        when(admissionService.calculateFees(associateId)).thenReturn(fees);

        mockMvc.perform(get("/calculateFees/{associateId}", associateId))
                .andExpect(status().isOk())
                .andExpect(content().string("5000"));

        verify(admissionService, times(1)).calculateFees(associateId);
        verifyNoMoreInteractions(admissionService);
    }

   

}
