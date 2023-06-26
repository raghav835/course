package com.cms.repository;

import com.cms.model.Course;

import java.util.List;

public interface CourseRepository {

    Course findById(String courseId);

    List<Course> findAll();

    void save(Course course);

    void delete(String courseId);

}
