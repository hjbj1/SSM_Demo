package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString
public class Role {

    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> userInfos;
}
