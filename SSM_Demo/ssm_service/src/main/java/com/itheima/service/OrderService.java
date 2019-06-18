package com.itheima.service;

import com.itheima.domain.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrderService {
    /**
     * 查询所有订单信息
     * @return
     */
    List<Order> findAll();
}
