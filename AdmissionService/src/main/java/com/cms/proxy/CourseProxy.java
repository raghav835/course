package com.cms.proxy;

import com.cms.model.Course;

public interface CourseProxy {
	
	Course getCourseById(String courseId);
	
	void addCourse(Course course);
	
	void updateCourse(Course course);
	
	void deleteCourse(String courseId);
	
	// Add more methods as per your course-related operations
}
