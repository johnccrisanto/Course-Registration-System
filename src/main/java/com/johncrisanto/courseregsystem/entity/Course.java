package com.johncrisanto.courseregsystem.entity;

import com.johncrisanto.courseregsystem.utils.DateAttributeConverterUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "course")
public class Course {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "start_date")
    @Convert (converter = DateAttributeConverterUtils.class)
    private LocalDate startDate;

    @Column (name = "end_date")
    @Convert (converter = DateAttributeConverterUtils.class)
    private LocalDate endDate;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "instructor_name")
    private String instructorName;

    @Column (name = "enrollment_limit")
    private int enrollmentLimit;

    @Column (name = "number_enrolled")
    private int numberEnrolled;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> enrolled;

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnrollmentLimit() {
        return enrollmentLimit;
    }

    public void setEnrollmentLimit(int enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }

    public int getNumberEnrolled() {
        return numberEnrolled;
    }

    public void setNumberEnrolled(int numberEnrolled) {
        this.numberEnrolled = numberEnrolled;
    }


    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public List<User> getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(List<User> enrolled) {
        this.enrolled = enrolled;
    }

}
