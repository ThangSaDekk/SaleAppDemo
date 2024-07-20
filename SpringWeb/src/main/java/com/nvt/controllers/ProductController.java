package com.nvt.controllers;

import com.nvt.pojo.Product;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
@Controller
public class ProductController {
    @RequestMapping("/addProduct")
    public String addProduct(Model model){
     
        model.addAttribute("product", new Product());
        return "addProduct";
    }
    
    
    @PostMapping("/addProduct")
    public String create(Model model, @ModelAttribute(value="product") @Valid Product p, BindingResult rs){
        if(rs.hasErrors())
            return "addProduct";
        return "redirect:/";
    }
}
