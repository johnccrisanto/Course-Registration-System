package com.johncrisanto.courseregsystem.dao;

import com.johncrisanto.courseregsystem.entity.Role;

public interface RoleDAO {
    Role findByRoleName(String roleName);
}
