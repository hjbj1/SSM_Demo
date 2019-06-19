package com.itheima.domain;

import com.itheima.utils.DateUtils;
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


    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr= DateUtils.dateToString(orderTime);
        }
        return orderTimeStr;
    }

    public String getOrderStatusStr() {
            // 状态 0 关闭 1 开启
            if(orderStatus == 0){
                orderStatusStr = "未支付";
            }
            if(orderStatus == 1){
                orderStatusStr = "已支付";
            }
        return orderStatusStr;
    }

    public String getPayTypeStr() {
        if(payType == 0){
            payTypeStr= "支付宝";
        }else if(payType == 1){
            payTypeStr= "微信";
        }else {
            payTypeStr= "其它";
        }
        return payTypeStr;
    }
}
