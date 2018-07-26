package com.johncrisanto.courseregsystem.dao;

import com.johncrisanto.courseregsystem.entity.User;

import java.util.List;

public interface UserDAO {

    void save(User newUser);

    List<User> getUsers();

    User findByUsername(String username);

    User findByEmail(String email);
}
