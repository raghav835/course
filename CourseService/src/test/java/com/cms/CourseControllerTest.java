package com.cms;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseControllerTest {

    @Mock
    private CourseService courseService;

    @Test
    public void test122RestApiCallForViewByCourseId() {
        // Arrange
        Mockito.when(courseService.viewByCourseId("123")).thenReturn(new Course());

        // Act
        ResponseEntity<Course> response = CourseController.viewByCourseId("123");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("123", response.getBody().getCourseId());
    }

    @Test
    public void test123RestApiCallForUpdateCourse() {
        // Arrange
        Mockito.when(courseService.updateCourse("123", 1000)).thenReturn(new Course());

        // Act
        ResponseEntity<Course> response = CourseController.updateCourse("123", 1000);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("123", response.getBody().getCourseId());
    }

    @Test
    public void test124RestApiCallForViewFeedbackRating() {
        // Arrange
        Mockito.when(courseService.viewFeedbackRating("123")).thenReturn(10);

        // Act
        ResponseEntity<Integer> response = CourseController.viewFeedbackRating("123");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(10, response.getBody());
    }

    @Test
    public void test125RestApiCallForCalculateAverageFeedback() {
        // Arrange
        Mockito.when(courseService.calculateAverageFeedback("123", 5)).thenReturn(8.0);

        // Act
        ResponseEntity<Double> response = CourseController.calculateAverageFeedback("123", 5);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(8.0, response.getBody());
    }

    @Test
    public void test126RestApiCallForAddCourse() {
        // Arrange
        Mockito.when(courseService.addCourse(new Course())).thenReturn(new Course());

        // Act
        ResponseEntity<Course> response = CourseController.addCourse(new Course());

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("1", response.getBody().getCourseId());
    }

    @Test
    public void test122RestApiCallForViewByCourseIdForInvalidId() {
        // Arrange
        Mockito.when(courseService.viewByCourseId("invalid")).thenReturn(null);

        // Act
        ResponseEntity<Course> response = CourseController.viewByCourseId("invalid");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void test122RestApiCallForViewByCourseIdForInvalidToken() {
        // Arrange
        Mockito.when(courseService.viewByCourseId("123")).thenReturn(null);

        // Act
        ResponseEntity<Course> response = CourseController.viewByCourseId("123", "invalid");

        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    public void test123RestApiCallForUpdateCourseForInvalidId() {
        // Arrange
        Mockito.when(courseService.updateCourse("invalid", 1000)).thenReturn(null);

        // Act
        ResponseEntity<Course> response = CourseController.updateCourse("invalid", 1000);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.get
