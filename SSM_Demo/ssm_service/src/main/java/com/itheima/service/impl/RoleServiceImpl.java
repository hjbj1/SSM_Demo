package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        try {
            return roleDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveRole(Role role) {
        try {
            roleDao.saveRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role findById(String id) {
        try {
            return roleDao.findByIdOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Permission> findExcludeRole(String id) {
        try {
            return roleDao.findExcludeRole(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addPermissionToRole(String roleId, String[] pms) {
        for (String pid : pms) {
            try {
                roleDao.addPermissionToRole(roleId,pid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
