package com.itheima.service.impl;

import com.itheima.dao.PermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissionsServiceImpl implements PermissionsService {

    @Autowired
    private PermissionDao permissionDao;


    @Override
    public List<Permission> findAll() {
        try {
            return permissionDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }
}
