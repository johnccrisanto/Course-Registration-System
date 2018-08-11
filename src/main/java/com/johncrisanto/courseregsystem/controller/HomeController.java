package com.johncrisanto.courseregsystem.controller;


import com.johncrisanto.courseregsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
