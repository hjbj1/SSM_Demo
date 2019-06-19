package com.itheima.dao;

import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {


    @Select("select * from users")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(column = "email", property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",many = @Many(select = "com.itheima.dao.RoleDao.findById"))
    })
    public UserInfo findByUserName(String username) throws Exception;





    @Select("select * from users")
    List<UserInfo> findAll();
}
