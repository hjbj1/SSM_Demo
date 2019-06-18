package com.itheima.controller;


import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查找所有产品信息
     * @param modelAndView
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Product> products = productService.findAll();
        modelAndView.addObject("productlist",products);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 保存产品信息
     * @param product
     * @return
     */
    @RequestMapping("/save.do")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:findAll";
    }
}
