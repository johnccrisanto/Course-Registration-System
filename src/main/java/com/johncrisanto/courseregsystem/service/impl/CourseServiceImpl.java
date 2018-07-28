package com.johncrisanto.courseregsystem.service.impl;

import com.johncrisanto.courseregsystem.dao.CourseDAO;
import com.johncrisanto.courseregsystem.entity.Course;
import com.johncrisanto.courseregsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDAO courseDAO;

    @Override
    @Transactional
    public List<Course> getCourses() {
        return courseDAO.getCourses();
    }

    @Override
    @Transactional
    public Course findByCourseName(String courseName) {
        return courseDAO.findByCourseName(courseName);
    }

    @Override
    @Transactional
    public void save(Course course) {
        courseDAO.save(course);
    }

    @Override
    @Transactional
    public Course findById(Long id) {
        return courseDAO.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        courseDAO.delete(id);
    }
}
