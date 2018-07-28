package com.johncrisanto.courseregsystem.controller;

import com.johncrisanto.courseregsystem.entity.Course;
import com.johncrisanto.courseregsystem.service.CourseService;
import com.johncrisanto.courseregsystem.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CourseService courseService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/")
    public String showAdminPage() {

        return "admin";
    }

    @GetMapping("/viewListOfCourses")
    public String viewListOfCourses(Model model) {

        List<Course> courses = courseService.getCourses();

        model.addAttribute("courses", courses);

        return "course-list";
    }

    @GetMapping("/addNewCoursePage")
    public String showAddNewCoursePage() {

        return "add-new-course-form";

    }

    @PostMapping("/processAddNewCourse")
    public String processAddNewCourse(HttpServletRequest request, Model model) {

        String courseName = request.getParameter("name");
        logger.info("Processing the addition of a course.");

        Course existingCourse = courseService.findByCourseName(courseName);

        if(existingCourse != null) {
            model.addAttribute("newCourse", new Course());
            model.addAttribute("addNewCourseError", true);
            logger.warning("The course name provided already exists.");
        } else {

            Course course = new Course();
            try {
                course.setName(courseName);
                course.setInstructorName(request.getParameter("instructorName"));
                course.setStartDate(DateUtils.parseDate(request.getParameter("startDate")));
                course.setEndDate(DateUtils.parseDate(request.getParameter("endDate")));
                course.setEnrollmentLimit(Integer.parseInt(request.getParameter("enrollmentLimit")));
                course.setNumberEnrolled(Integer.parseInt(request.getParameter("numberEnrolled")));
                course.setDescription(request.getParameter("description"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            courseService.save(course);
            logger.info("The registration as a new user was successful.");
            model.addAttribute("addSuccess", true);
        }

        return "add-new-course-form";
    }

    @GetMapping("/showAddNewFormForUpdate")
    public String showAddNewCoursePageForUpdate(@RequestParam("courseId") Long id, Model model) {

        Course course = courseService.findById(id);

        model.addAttribute("course", course);

        return "add-new-course-form";
    }

    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") Long id, Model model) {

        courseService.delete(id);

        model.addAttribute("deleteSuccess", true);
        return "course-list";
    }

}
