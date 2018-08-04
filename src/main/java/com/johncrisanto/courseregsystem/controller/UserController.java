package com.johncrisanto.courseregsystem.controller;

import com.johncrisanto.courseregsystem.entity.User;
import com.johncrisanto.courseregsystem.service.CourseService;
import com.johncrisanto.courseregsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/myProfile")
    @ResponseBody
    public String showProfile(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        return "TBD";
    }
}
