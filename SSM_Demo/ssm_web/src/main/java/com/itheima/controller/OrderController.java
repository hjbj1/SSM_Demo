package com.itheima.controller;

import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Order> orderLists = orderService.findAll();
        modelAndView.addObject("orderList",orderLists);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }
}
