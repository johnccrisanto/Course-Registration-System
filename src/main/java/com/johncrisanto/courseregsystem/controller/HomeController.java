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
    public String showHomePage(Principal principal) {
        System.out.println(principal.getName());
        return "home";
    }

    @GetMapping("/listUsers")
    public String showUsers(Model model) {

        List<User> userList = userService.getUsers();

        model.addAttribute("users", userList);

        return "list-users";
    }
}
