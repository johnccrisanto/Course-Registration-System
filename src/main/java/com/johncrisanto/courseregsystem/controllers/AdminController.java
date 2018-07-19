package com.johncrisanto.courseregsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String showAdminPage(Principal principal) {
        System.out.println(principal.getName());
        return "admin";
    }
}
