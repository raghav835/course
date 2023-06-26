package com.cms.model;

import java.util.Objects;

public class Course {

    private String courseId;
    private String courseName;
    private Integer fees;
    private Integer duration;
    private String courseType;
    private float rating;

    public Course() {
    }

    public Course(String courseId, String courseName, Integer fees, Integer duration, String courseType, float rating) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fees = fees;
        this.duration = duration;
        this.courseType = courseType;
        this.rating = rating;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(fees, course.fees) &&
                Objects.equals(duration, course.duration) &&
                Objects.equals(courseType, course.courseType) &&
                Float.compare(course.rating, rating) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, fees, duration, courseType, rating);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", fees=" + fees +
                ", duration=" + duration +
                ", courseType='" + courseType + '\'' +
                ", rating=" + rating +
                '}';
    }
}
