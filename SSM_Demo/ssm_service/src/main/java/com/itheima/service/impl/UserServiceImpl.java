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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 根据用户名登录获取权限
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthorities(userInfo));
        return user;
    }

    /**
     * UserDetails里面的子类User里的authorities获取权限集合方法
     * @param userInfo
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthorities(UserInfo userInfo){
        List<SimpleGrantedAuthority> authorities= new ArrayList<>();
        List<Role> roles = userInfo.getRoles();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authorities;
    }

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        try {
            return userDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 保存用户
     * @param userInfo
     */
    @Override
    public void saveUser(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        try {
            userDao.saveUser(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> findExcludeRole(String id) {
        try {
            return userDao.findExcludeRole(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String rid : ids) {
            try {
                userDao.addRoleToUser(userId,rid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据id查找user
     * @param id
     * @return
     */
    @Override
    public UserInfo findById(String id) {
        try {
            return userDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
