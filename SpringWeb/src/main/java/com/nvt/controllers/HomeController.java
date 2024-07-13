/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.controllers;

import com.nvt.service.CategoryService;
import com.nvt.service.ProductService;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService cateService;
    @Autowired
    private ProductService prodService;
    
    
    @RequestMapping("/")
    @Transactional
    public String index(){
        return "index";
    }
    
    
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("cates", this.cateService.getCategory());
        model.addAttribute("products", prodService.getProducts(null));
        return "login";
    }
}
