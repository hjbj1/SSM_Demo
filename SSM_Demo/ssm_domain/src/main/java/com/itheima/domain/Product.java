package com.itheima.domain;

import java.util.Date;
import com.itheima.utils.DateUtils;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {

    private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    private Date departureTime; // 出发时间
    private String departureTimeStr;
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;

    public String getDepartureTimeStr() {
        if(departureTimeStr == null){
            departureTimeStr = DateUtils.dateToString(departureTime);
        }
        return departureTimeStr;
    }

    public String getProductStatusStr() {
        if(productStatusStr == null){
            // 状态 0 关闭 1 开启
            if(productStatus == 0){
                productStatusStr = "关闭";
            }
            if(productStatus == 1){
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }

}
