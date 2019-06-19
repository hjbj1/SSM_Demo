package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleInfo;
import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUserName(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthorities(userInfo));

        return user;
    }


    public List<SimpleGrantedAuthority> getAuthorities(UserInfo userInfo){
        List<SimpleGrantedAuthority> authorities= new ArrayList<>();
        List<Role> roles = userInfo.getRoles();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }
}
