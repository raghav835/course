package com.cms.proxy;

import com.cms.model.Course;

public interface CourseProxy {

    /**
     * Create a new course.
     *
     * @param course The course object to be created.
     * @return The created course object.
     */
    Course createCourse(Course course);

    /**
     * Update an existing course.
     *
     * @param course The course object to be updated.
     * @return The updated course object.
     */
    Course updateCourse(Course course);

    /**
     * Get a course by its ID.
     *
     * @param courseId The ID of the course.
     * @return The course object.
     */
    Course getCourseById(String courseId);

    /**
     * Delete a course by its ID.
     *
     * @param courseId The ID of the course.
     */
    void deleteCourseById(String courseId);
}
