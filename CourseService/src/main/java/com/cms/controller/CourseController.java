package com.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public String getCourses() {
        return "["
                + "{"
                + "   \"id\": 1,"
                + "   \"name\": \"Spring Boot\""
                + "},"
                + "{"
                + "   \"id\": 2,"
                + "   \"name\": \"Java EE\""
                + "}"
                + "]";
    }
}
