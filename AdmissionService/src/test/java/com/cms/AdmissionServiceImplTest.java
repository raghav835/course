package com.cms;

import com.cms.exception.AdmissionInvalidException;
import com.cms.model.Admission;
import com.cms.service.AdmissionServiceImpl;
import com.cms.service.IAdmissionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdmissionServiceImplTest {

    @Mock
    private IAdmissionService admissionService;

    @InjectMocks
    private AdmissionServiceImpl admissionServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateFees() {
        String associateId = "A001";
        int expectedFees = 5000;

        when(admissionService.calculateFees(associateId)).thenReturn(expectedFees);

        int fees = admissionServiceImpl.calculateFees(associateId);

        assertEquals(expectedFees, fees);
        verify(admissionService, times(1)).calculateFees(associateId);
    }

    @Test
    public void testAddFeedback() throws AdmissionInvalidException {
        Long regNo = 123L;
        String feedback = "Good course";
        float feedbackRating = 4.5f;

        Admission admission = new Admission();
        admission.setRegNo(regNo);
        admission.setFeedback(feedback);
        admission.setFeedbackRating(feedbackRating);

        when(admissionService.addFeedback(regNo, feedback, feedbackRating)).thenReturn(admission);

        Admission result = admissionServiceImpl.addFeedback(regNo, feedback, feedbackRating);

        assertEquals(admission, result);
        verify(admissionService, times(1)).addFeedback(regNo, feedback, feedbackRating);
    }

    @Test
    public void testHighestFeeForTheRegisteredCourse() throws AdmissionInvalidException {
        String associateId = "A001";
        List<String> courses = new ArrayList<>();
        courses.add("Course 1");
        courses.add("Course 2");
        courses.add("Course 3");

        when(admissionService.highestFeeForTheRegisteredCourse(associateId)).thenReturn(courses);

        List<String> result = admissionServiceImpl.highestFeeForTheRegisteredCourse(associateId);

        assertEquals(courses, result);
        verify(admissionService, times(1)).highestFeeForTheRegisteredCourse(associateId);
    }

    @Test
    public void testViewFeedbackByCourseId() throws AdmissionInvalidException {
        String courseId = "C001";
        List<String> feedbacks = new ArrayList<>();
        feedbacks.add("Feedback 1");
        feedbacks.add("Feedback 2");
        feedbacks.add("Feedback 3");

        when(admissionService.viewFeedbackByCourseId(courseId)).thenReturn(feedbacks);

        List<String> result = admissionServiceImpl.viewFeedbackByCourseId(courseId);

        assertEquals(feedbacks, result);
        verify(admissionService, times(1)).viewFeedbackByCourseId(courseId);
    }

    @Test
    public void testDeactivateAdmission() throws AdmissionInvalidException {
        String courseId = "C001";

        when(admissionService.deactivateAdmission(courseId)).thenReturn(true);

        boolean result = admissionServiceImpl.deactivateAdmission(courseId);

        assertTrue(result);
        verify(admissionService, times(1)).deactivateAdmission(courseId);
    }



}
