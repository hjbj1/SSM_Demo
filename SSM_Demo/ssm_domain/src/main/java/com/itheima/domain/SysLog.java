package com.itheima.domain;

import com.itheima.utils.DateUtils;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
public class SysLog {

    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public String getVisitTimeStr() {
        if(visitTime!=null){
            visitTimeStr= DateUtils.dateToString(visitTime);
        }
        return visitTimeStr;
    }
}
