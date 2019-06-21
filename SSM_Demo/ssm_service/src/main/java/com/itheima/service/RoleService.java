package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;



public interface RoleService {
    List<Role> findAll();

    void saveRole(Role role);

    Role findById(String id);

    List<Permission> findExcludeRole(String id);

    void addPermissionToRole(String roleId, String[] pms);
}
