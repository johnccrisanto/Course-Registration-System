package com.johncrisanto.courseregsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/accessDeniedPage")
    public String showAccessDeniedPage() {
        return "denied";
    }
}
