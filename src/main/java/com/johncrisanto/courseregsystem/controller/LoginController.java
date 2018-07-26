package com.johncrisanto.courseregsystem.controller;

import com.johncrisanto.courseregsystem.entity.User;
import com.johncrisanto.courseregsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
