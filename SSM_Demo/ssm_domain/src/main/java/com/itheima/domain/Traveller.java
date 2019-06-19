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


    public String getCredentialsTypeStr(){
        if(credentialsType == 0){
            credentialsTypeStr = "身份证";
        }
        if(credentialsType == 1){
            credentialsTypeStr = "护照";
        }
        if(credentialsType == 2){
            credentialsTypeStr = "军官证";
        }
        return credentialsTypeStr;
    }


    public String getTravellerTypeStr(){
        if(travellerType == 0){
            travellerTypeStr = "成人";
        }
        if(travellerType == 1){
            travellerTypeStr = "儿童";
        }

        return travellerTypeStr;
    }
}
