package com.itheima.domain;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Traveller {
private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;
}
