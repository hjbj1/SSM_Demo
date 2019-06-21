package com.itheima.controller;


import com.itheima.domain.Permission;
import com.itheima.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionsService permissionsService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Permission> permissions = permissionsService.findAll();
        modelAndView.addObject("permissions",permissions);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }
}
