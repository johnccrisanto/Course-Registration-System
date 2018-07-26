package com.johncrisanto.courseregsystem.dao.impl;

import com.johncrisanto.courseregsystem.dao.RoleDAO;
import com.johncrisanto.courseregsystem.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Role findByRoleName(String roleName) {
        // Get hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create query to retrieve role from db if it exists by its name
        Query<Role> query = currentSession.createQuery("FROM Role r WHERE r.name = :rollName", Role.class);
        query.setParameter("rollName", roleName);

        Role role = null;

        try {
            role = query.getSingleResult();
        } catch (Exception e) {
            role = null;
        }
        return role;
    }
}
