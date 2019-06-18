package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;


@Data
@ToString
public class Order {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;
}
