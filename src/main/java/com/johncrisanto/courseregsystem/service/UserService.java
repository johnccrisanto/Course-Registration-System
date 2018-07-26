package com.johncrisanto.courseregsystem.service;

import com.johncrisanto.courseregsystem.entity.User;
import com.johncrisanto.courseregsystem.user.CourseRegSystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getUsers();

    User findByUsername(String username);

    User findByEmail(String email);

    void save(CourseRegSystemUser user);
}
