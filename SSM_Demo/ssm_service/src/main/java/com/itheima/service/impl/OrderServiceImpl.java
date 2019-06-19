package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public List<Order> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        try {
            return orderDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Order findById(String id) {
        try {
            return orderDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
