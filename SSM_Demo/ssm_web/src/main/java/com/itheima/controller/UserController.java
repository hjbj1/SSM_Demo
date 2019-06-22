package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<UserInfo> users = userService.findAll();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUser")
    @PreAuthorize("authentication.principal.username == 'gtw'")
    public String saveUser(UserInfo userInfo){
        userService.saveUser(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(ModelAndView modelAndView,String id){
        UserInfo user = userService.findById(id);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }



    @RequestMapping("/findUserByIdAndExcludeRole.do")
    public ModelAndView findUserByIdAndExcludeRole(String id,ModelAndView modelAndView){
//        UserInfo user = userService.findById(id);
        modelAndView.addObject("id",id);
        List<Role> roles = userService.findExcludeRole(id);
        modelAndView.addObject("roles",roles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String userId,String[] ids){
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }

}
