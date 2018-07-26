package com.johncrisanto.courseregsystem.controller;

import com.johncrisanto.courseregsystem.entity.Course;
import com.johncrisanto.courseregsystem.entity.User;
import com.johncrisanto.courseregsystem.service.UserService;
import com.johncrisanto.courseregsystem.user.CourseRegSystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

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

        if(existingUser != null) {
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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(" ",true);
        binder.registerCustomEditor(String.class, editor);
    }

}
