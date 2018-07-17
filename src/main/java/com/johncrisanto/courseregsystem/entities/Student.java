package com.johncrisanto.courseregsystem.entities;

import java.util.List;

public class Student extends RegisteredUser {

    private List<Course> registeredCourses;

    public Student() {

    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }
}
