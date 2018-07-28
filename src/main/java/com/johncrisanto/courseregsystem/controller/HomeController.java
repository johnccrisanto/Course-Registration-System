package com.johncrisanto.courseregsystem.controller;


import com.johncrisanto.courseregsystem.entity.User;
import com.johncrisanto.courseregsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/showProfilePage")
    public String showProfilePage() {

        return "profile-page";

    }

}
