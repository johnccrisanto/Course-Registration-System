package com.johncrisanto.courseregsystem.dao;

import com.johncrisanto.courseregsystem.entity.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> getCourses();

    Course findByCourseName(String courseName);

    void save(Course course);

    Course findById(Long id);

    void delete(Long id);
}
