package com.johncrisanto.courseregsystem.dao.impl;

import com.johncrisanto.courseregsystem.dao.CourseDAO;
import com.johncrisanto.courseregsystem.entity.Course;
import com.johncrisanto.courseregsystem.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> getCourses() {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query  ... sort by last name
        Query<Course> theQuery =
                currentSession.createQuery("FROM Course ORDER BY name",
                        Course.class);

        // Execute query and get result list
        List<Course> courses = theQuery.getResultList();

        // Return the results
        return courses;
    }

    @Override
    public Course findByCourseName(String courseName) {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query to retrieve a course with the provided course name
        Query<Course> query =
                currentSession.createQuery("FROM Course c WHERE c.name = :courseName",
                        Course.class);
        query.setParameter("courseName", courseName);


        // Execute query and get result list
        List<Course> courses = query.getResultList();

        // Return the results
        return (!courses.isEmpty() ? courses.get(0) : null);
    }

    @Override
    public Course findById(Long id) {
        // Get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Retrieve the corresponding course with the provided id
        Course course = currentSession.get(Course.class, id);

        return course;
    }

    @Override
    public void save(Course course) {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Save the course onto the database
        currentSession.saveOrUpdate(course);
    }

    @Override
    public void delete(Long id) {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query to delete the corresponding course
        Query<Course> query = currentSession.createQuery("DELETE FROM Course c WHERE c.id = :courseId");
        query.setParameter("courseId", id);
        query.executeUpdate();
    }

    @Override
    public List<Course> getUserCourses(User user) {

        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create the query
        Query<Course> query = currentSession.createQuery("SELECT c FROM Course c JOIN c.enrolled e WHERE e.id = :idUser");
        query.setParameter("idUser", user.getId());

        List<Course> courseList = query.getResultList();

        return courseList;
    }
}
