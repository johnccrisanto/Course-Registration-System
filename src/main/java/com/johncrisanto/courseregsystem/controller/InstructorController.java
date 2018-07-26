package com.johncrisanto.courseregsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    @GetMapping("/")
    public String showInstructorPage(Principal principal) {
        System.out.println(principal.getName());
        return "instructor";
    }

}
