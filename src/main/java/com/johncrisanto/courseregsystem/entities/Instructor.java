package com.johncrisanto.courseregsystem.entities;

import java.util.List;

public class Instructor extends RegisteredUser {

    private List<Course> currentlyInstructing;

    public Instructor() {

    }

    public List<Course> getCurrentlyInstructing() {
        return currentlyInstructing;
    }

    public void setCurrentlyInstructing(List<Course> currentlyInstructing) {
        this.currentlyInstructing = currentlyInstructing;
    }
}
