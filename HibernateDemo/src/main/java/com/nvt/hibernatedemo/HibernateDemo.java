/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.nvt.hibernatedemo;

import com.nvt.pojo.Cart;
import com.nvt.repository.impl.CategoryRepositoryImpl;
import com.nvt.repository.impl.ProductRepositoryImpl;
import com.nvt.repository.impl.ReciptRepositoryImpl;
import com.nvt.repository.impl.StatsRepositoryImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl c = new CategoryRepositoryImpl();
//        c.getCategory().forEach(i -> System.out.println(i.getName()));
//
//        ProductRepositoryImpl k = new ProductRepositoryImpl();
//        Map<String, String> params = new HashMap<>();
////        params.put("kw", "Iphone");
////        params.put("fromPrice", "28000000");
////        params.put("toPrice", "30000000");
////        params.put("category","1" );
//        params.put("page","1");
//        k.getProducts(params).forEach(i -> System.out.printf("%d - %s - %d\n",i.getId(),i.getName(),i.getPrice()));
//          params.put("page","2");
//        k.getProducts(params).forEach(i -> System.out.printf("%d - %s - %d\n",i.getId(),i.getName(),i.getPrice()));
//          params.put("page","3");
//        k.getProducts(params).forEach(i -> System.out.printf("%d - %s - %d\n",i.getId(),i.getName(),i.getPrice()));
//          List<Cart> carts = new ArrayList<>();
//          carts.add(new Cart(1,"A",2,1000l));
//          
//          ReciptRepositoryImpl r = new ReciptRepositoryImpl();
//          r.addRecipt(carts);
        StatsRepositoryImpl stats = new StatsRepositoryImpl();
        stats.statsRevenueByProduct().forEach(q -> System.out.printf("%d - %s: %d\n",q[0],q[1],q[2]));
        
        stats.statsRevenueByPeriod(2020, "MONTH").forEach(q -> System.out.printf("Thang %d: %d\n", q[0],q[1]));
    }
}
