package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Role> roles = roleService.findAll();
        modelAndView.addObject("roles",roles);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }


    @RequestMapping("/saveRole.do")
    public String save(Role role) {
        roleService.saveRole(role);
        return "redirect:findAll.do";
    }




    @RequestMapping("/findRoleByIdAndExcludePermission.do")
    public ModelAndView findRoleByIdAndExcludePermission(String id,ModelAndView modelAndView){
//        Role role = roleService.findById(id);
        modelAndView.addObject("roleid",id);
        List<Permission> permissions = roleService.findExcludeRole(id);
        modelAndView.addObject("permissions",permissions);
        modelAndView.setViewName("role-perssion-add");
        return modelAndView;
    }



    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(String roleId,String[] pms){
        roleService.addPermissionToRole(roleId,pms);
        return "redirect:findAll.do";
    }
}
