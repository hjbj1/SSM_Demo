package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {


    @Select("select * from users where username = #{username}")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(column = "email", property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = "com.itheima.dao.RoleDao.findById"))
    })
    UserInfo findByUserName(String username) throws Exception;





    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Select("select * from users where id = #{id}")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(column = "email", property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = "com.itheima.dao.RoleDao.findById"))
    })
    UserInfo findById(String id) throws Exception;


    @Insert("insert into users(username,email,password,phoneNum,status) values (#{username},#{email},#{password},#{phoneNum},#{status})")
    void saveUser(UserInfo userInfo) throws Exception;

    @Select("select * from role where id not in (select roleid from users_role where userid = #{id})")
    List<Role> findExcludeRole(String id) throws Exception;


    @Insert("insert into users_role (userid,roleid) values (#{userId},#{rid})")
    void addRoleToUser(@Param("userId") String userId,@Param("rid") String rid) throws Exception;
}
