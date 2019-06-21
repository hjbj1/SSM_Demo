package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {


    @Select("select * from role where id in (select roleid from users_role where userid = #{id})")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,many = @Many(select = "com.itheima.dao.PermissionDao.findByRoleId"))
    })
    public List<Role> findById(String id) throws Exception;
}
