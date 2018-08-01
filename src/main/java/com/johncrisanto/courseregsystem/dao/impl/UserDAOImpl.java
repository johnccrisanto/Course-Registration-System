package com.johncrisanto.courseregsystem.dao.impl;

import com.johncrisanto.courseregsystem.dao.UserDAO;
import com.johncrisanto.courseregsystem.entity.Course;
import com.johncrisanto.courseregsystem.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query  ... sort by last name
        Query<User> query =
                currentSession.createQuery("FROM User ORDER BY lastName",
                        User.class);

        // Execute query and get result list
        List<User> customers = query.getResultList();

        // Return the results
        return customers;
    }

    @Override
    public User findByUsername(String username) {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query
        Query<User> query = currentSession.createQuery("FROM User u WHERE u.username= :username", User.class);
        query.setParameter("username", username);

        // Execute query and attempt to retrieve a user from the db with the id that is passed in
        List<User> userList = query.getResultList();

        User user = (!userList.isEmpty()) ?  userList.get(0) : null;

        // return the results
        return user;
    }

    @Override
    public User findByUsernameAll(String username) {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query
        Query<User> query = currentSession.createQuery("FROM User u WHERE u.username= :username", User.class);
        query.setParameter("username", username);

        // Execute query and attempt to retrieve a user from the db with the id that is passed in
        List<User> userList = query.getResultList();

        User user = (!userList.isEmpty()) ?  userList.get(0) : null;

        if(user != null) user.getCourses();
        // return the results
        return user;
    }

    @Override
    public User findByEmail(String email) {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query
        Query<User> query = currentSession.createQuery("FROM User u WHERE u.email= :email").setParameter("email", email);

        // Execute query and attempt to retrieve a user from the db with the id that is passed in
        List<User> userList = query.getResultList();

        User user = (!userList.isEmpty()) ?  userList.get(0) : null;

        // return the results
        return user;
    }

    @Override
    public void save(User newUser) {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Save the new user onto the db
        currentSession.save(newUser);
    }

    @Override
    public void saveUser(User user) {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Save the new user onto the db
        currentSession.saveOrUpdate(user);
    }

    @Override
    public void addCourse(Course course, Long id) {

        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        User user = currentSession.get(User.class, id);

        user.addCourse(course);

        course.incrementNumberEnrolled();

        currentSession.merge(user);
        currentSession.merge(course);

    }

    @Override
    public void removeCourse(Course course, Long id) {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        User user = currentSession.get(User.class, id);

        for(Course temp: user.getCourses()) {
            System.out.println("Course Name: " + temp.getName());
        }

        user.removeCourse(course);

        course.decrementNumberEnrolled();

        currentSession.merge(user);
        currentSession.merge(course);
    }
}
