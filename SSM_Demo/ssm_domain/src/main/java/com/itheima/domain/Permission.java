package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString
public class Permission {

    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
