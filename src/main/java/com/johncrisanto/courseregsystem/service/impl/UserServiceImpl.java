package com.johncrisanto.courseregsystem.service.impl;

import com.johncrisanto.courseregsystem.dao.RoleDAO;
import com.johncrisanto.courseregsystem.dao.UserDAO;
import com.johncrisanto.courseregsystem.entity.Course;
import com.johncrisanto.courseregsystem.entity.Role;
import com.johncrisanto.courseregsystem.entity.User;
import com.johncrisanto.courseregsystem.service.UserService;
import com.johncrisanto.courseregsystem.user.CourseRegSystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public User findByUsernameAll(String username) {
        return userDAO.findByUsernameAll(username);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDAO.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("The username was not found.");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(CourseRegSystemUser user) {
        User newUser = new User();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setRoles(Arrays.asList(roleDAO.findByRoleName("ROLE_STUDENT")));

        userDAO.save(newUser);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void addCourse(Course course, Long id) {
        userDAO.addCourse(course, id);
    }

    @Override
    @Transactional
    public void removeCourse(Course course, Long id) {
        userDAO.removeCourse(course, id);
    }
}
