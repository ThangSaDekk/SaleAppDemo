/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.repository.impl;

import com.nvt.hibernatedemo.HibernateUtils;
import com.nvt.pojo.Cart;
import com.nvt.pojo.OrderDetail;
import com.nvt.pojo.SaleOrder;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ReciptRepositoryImpl {

    private static final UserRepositoryImpl u = new UserRepositoryImpl();
    private static final ProductRepositoryImpl pr = new ProductRepositoryImpl();

    public void addRecipt(List<Cart> carts) {
        if (carts != null) {
            try (Session s = HibernateUtils.getFactory().openSession()) {
                SaleOrder order = new SaleOrder();
                order.setUserId(u.getUserByUsername("dhthanh"));
                order.setCreatedDate(new Date());
                s.save(order);
                
                for (var c : carts){
                    OrderDetail d = new OrderDetail();
                    d.setProductId(pr.getProductById(c.getId()));
                    d.setOrderId(order);
                    d.setQuantity(c.getQuantity());
                    d.setUnitPrice(c.getUnitPrice());
                    
                    s.save(d);
                }
            }
        }
    }
}
