package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("select * from permission where id in (select permissionid from role_permission where roleid = #{roleid})")
    List<Permission> findByRoleId(String roleid);


    @Select("select * from permission")
    List<Permission> findAll() throws Exception;
}
