package com.cms;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @Test
    public void test127AddCourse() {
        // Arrange
        Course course = new Course();
        course.setCourseId("123");
        course.setCourseName("Java");
        course.setFees(1000);

        Mockito.when(courseRepository.save(course)).thenReturn(course);

        // Act
        CourseServiceImpl courseService = new CourseServiceImpl(courseRepository);
        Course savedCourse = courseService.addCourse(course);

        // Assert
        assertEquals(course, savedCourse);
    }

    @Test
    public void test128ViewByCourseId() {
        // Arrange
        Course course = new Course();
        course.setCourseId("123");
        course.setCourseName("Java");
        course.setFees(1000);

        Mockito.when(courseRepository.findById("123")).thenReturn(java.util.Optional.of(course));

        // Act
        CourseServiceImpl courseService = new CourseServiceImpl(courseRepository);
        Course foundCourse = courseService.viewByCourseId("123");

        // Assert
        assertEquals(course, foundCourse);
    }

    @Test
    public void test129FindFeedbackRatingForCourseId() {
        // Arrange
        int feedbackRating = 5;

        Mockito.when(courseRepository.findFeedbackRating("123")).thenReturn(feedbackRating);

        // Act
        CourseServiceImpl courseService = new CourseServiceImpl(courseRepository);
        int foundFeedbackRating = courseService.findFeedbackRatingForCourseId("123");

        // Assert
        assertEquals(feedbackRating, foundFeedbackRating);
    }

    @Test
    public void test130UpdateCourse() {
        // Arrange
        Course course = new Course();
        course.setCourseId("123");
        course.setCourseName("Java");
        course.setFees(1000);

        Mockito.when(courseRepository.save(course)).thenReturn(course);

        // Act
        CourseServiceImpl courseService = new CourseServiceImpl(courseRepository);
        Course updatedCourse = courseService.updateCourse("123", 1500);

        // Assert
        assertEquals(course, updatedCourse);
    }

    @Test
    public void test131CalculateAverageFeedbackAndUpdate() {
        // Arrange
        Course course = new Course();
        course.setCourseId("123");
        course.setCourseName("Java");
        course.setFees(1000);

        int feedbackRating = 5;
        int existingFeedbackRating = 3;
        double averageFeedback = (feedbackRating + existingFeedbackRating) / 2.0;

        Mockito.when(courseRepository.findById("123")).thenReturn(java.util.Optional.of(course));
        Mockito.when(courseRepository.save(course)).thenReturn(course);

        // Act
        CourseServiceImpl courseService = new CourseServiceImpl(courseRepository);
        double calculatedAverageFeedback = courseService.calculateAverageFeedbackAndUpdate("123", feedbackRating);

        // Assert
        assertEquals(averageFeedback, calculatedAverageFeedback);
    }

    @Test
    public void test132DeactivateCourse() {
        // Arrange
        Course course = new Course();
        course.setCourseId("123");
        course.setCourseName("Java");
        course.setFees(1000);

        Mockito.when(courseRepository.findById("123")).thenReturn
