package com.johncrisanto.courseregsystem.rest;

import com.johncrisanto.courseregsystem.entity.Course;
import com.johncrisanto.courseregsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/courses", produces = {"APPLICATION/JSON"})
    public List<Course> getCourses() {
        // Retrieve the courses from the database
        List<Course> courses = courseService.getCourses();

        // Return the list of courses to be sent in JSON format (conversion performed by Jackson)
        return courses;
    }
}
