package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("findAll.do")
    @Secured("ROLE_ADMIN")      //Secured注解需要输入全角色名称,是security里面的,不需要导包
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "5") Integer pageSize,
                                ModelAndView modelAndView){
        List<Order> orderLists = orderService.findAll(page,pageSize);
        PageInfo orderPageInfo = new PageInfo(orderLists);
        modelAndView.addObject("pageInfo",orderPageInfo);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }


    @RequestMapping("findById.do")
    public ModelAndView findById(String id,ModelAndView modelAndView){
        Order order = orderService.findById(id);
        modelAndView.addObject("orders",order);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
