package com.itheima.service;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    List<UserInfo> findAll();

    UserInfo findById(String id);

    void saveUser(UserInfo userInfo);

    List<Role> findExcludeRole(String id);

    void addRoleToUser(String userId, String[] ids);
}
