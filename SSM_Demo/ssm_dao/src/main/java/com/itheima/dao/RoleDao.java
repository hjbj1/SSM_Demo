package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RoleDao {


    @Select("select * from role where id in (select roleid from users_role where userid = #{id})")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,many = @Many(select = "com.itheima.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findById(String id) throws Exception;


    @Select("select * from role")
    List<Role> findAll() throws Exception;



    @Insert("insert into role(roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void saveRole(Role role) throws Exception;


    @Select("select * from role where id = #{id}")
    Role findByIdOne(String id) throws Exception;


    @Select("select * from permission where id not in (select permissionid from role_permission where roleid = #{id})")
    List<Permission> findExcludeRole(String id);



    @Insert("insert into role_permission (roleid,permissionid) values (#{roleId},#{pid})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("pid")String pid) throws Exception;
}
