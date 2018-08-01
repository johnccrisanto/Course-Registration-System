package com.johncrisanto.courseregsystem.controller;

import com.johncrisanto.courseregsystem.entity.Course;
import com.johncrisanto.courseregsystem.entity.User;
import com.johncrisanto.courseregsystem.service.CourseService;
import com.johncrisanto.courseregsystem.service.UserService;
import com.johncrisanto.courseregsystem.user.CourseRegSystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/newUserRegistrationPage")
    public String showRegistrationForm(Model model) {

        // Create a user object and store into the model for data binding
        model.addAttribute("newUser", new CourseRegSystemUser());

        return "new-user-registration-form";
    }

    @PostMapping("/processNewUserRegistration")
    public String processNewUserRegistration(@ModelAttribute("newUser") CourseRegSystemUser user, Model model) {

        String username = user.getUsername();
        logger.info("Processing registration form for: " + username);

        User existingUser = userService.findByUsername(username);

        if (existingUser != null) {
            model.addAttribute("newUser", new CourseRegSystemUser());
            model.addAttribute("registrationError", true);
            logger.warning("The username provided already exists.");
            return "new-user-registration-form";
        }

        userService.save(user);

        logger.info("The registration as a new user was successful.");

        return "new-user-registration-confirmation";
    }

    @RequestMapping("/validateUsername")
    @ResponseBody
    public String validateUsername(@RequestParam("username") String username) {
        System.out.println(username);
        User user = userService.findByUsername(username);
        System.out.println(user);
        String message = "";

        if (user != null) {
            message = "The username provided already exists.";
        }

        return message;
    }

    @RequestMapping("/validateEmail")
    @ResponseBody
    public String validateEmail(@RequestParam("email") String email) {

        User user = userService.findByEmail(email);

        String message = "";


        if (user != null) {
            message = "The email address provided already exists.";
        }

        return message;
    }

    @RequestMapping("/registerForCourse")
    @ResponseBody
    public String registerForCourse(@RequestParam("id") Long id, Principal principal) {
        // Retrieve the authenticated user
        User user = userService.findByUsername(principal.getName());

        // Retrieve the courses associated with the authenticated user
        List<Course> courses = courseService.getUserCourses(user);

        // Retrieve the course the user wants to register for by the id that is passed in from the view page
        Course course = courseService.findById(id);

        boolean contains = courses.contains(course);
        System.out.println(contains);

        String message;
        // Checks if the user is already registered for the course
        if (contains) {
            message = "You are already registered for this course.";
        } else {

            // Compare the current date with the date for which the course starts
            // A student should not be able to register for a course that has already started
            LocalDate current = LocalDate.now();

            // Checks if the current date is after the start date of the course
            if (current.isAfter(course.getStartDate())) {
                message = "Unfortunately, you cannot register for a course that has already started.";
            } else {
                // Checks if the number enrolled is greater than or equal to the enrollment limit
                // Technically should never exceed the enrollment limit because only default constructor was available,
                // user can accidentally set initial number enrolled number to be greater than limit when adding a new course
                if (course.getNumberEnrolled() >= course.getEnrollmentLimit()) {
                    message = "Unfortunately, the course is currently full.";
                } else {
                    // If it gets to this portion of the code that means the user should be able to register for the course
                    // Add course to student list of courses
                    userService.addCourse(course, user.getId());

                    message = "You have successfully registered for this course.";
                }
            }
        }
        return message;
    }

    @RequestMapping("/unregisterFromCourse")
    @ResponseBody
    public String unregisterFromCourse(@RequestParam("id") Long id, Principal principal) {

        // Retrieve the authenticated user
        User user = userService.findByUsername(principal.getName());

        // Retrieve the courses associated with the authenticated user
        List<Course> courses = courseService.getUserCourses(user);

        // Retrieve the course the user wants to unregister from by the id that is passed in from the view page
        Course course = courseService.findById(id);

        boolean contains = courses.contains(course);

        String message;
        // Checks if the user is not registered for the course
        if (!contains) {
            message = "You cannot unregister from a course for which you are not registered for.";
        } else {
            // If it gets to this portion of the code that means the user should be able to unregister from the course

            userService.removeCourse(course, user.getId());

            message = "You have successfully unregistered from this course.";
        }

        return message;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(" ", true);
        binder.registerCustomEditor(String.class, editor);
    }


}
