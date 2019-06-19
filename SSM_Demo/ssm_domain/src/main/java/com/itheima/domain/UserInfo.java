package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;


    public String getStatusStr(){
        if (status == 0){
            statusStr = "未开启";
        }
        if (status == 1){
            statusStr = "开启";
        }
        return statusStr;
    }
}
