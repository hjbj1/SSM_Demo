package com.itheima.domain;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Member {

    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}
