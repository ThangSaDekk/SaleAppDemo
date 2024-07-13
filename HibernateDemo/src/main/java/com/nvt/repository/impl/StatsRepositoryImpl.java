/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.repository.impl;

import com.nvt.hibernatedemo.HibernateUtils;
import com.nvt.pojo.OrderDetail;
import com.nvt.pojo.Product;
import com.nvt.pojo.SaleOrder;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author thang
 */
public class StatsRepositoryImpl {
    public List<Object[]> statsRevenueByProduct(){
        try(Session s = HibernateUtils.getFactory().openSession()){
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            
            Root rP = q.from(Product.class);
            Root rD = q.from(OrderDetail.class);
            
            q.where(b.equal(rP.get("id"), rD.get("productId")));
            q.multiselect(rP.get("id"), rP.get("name"), b.sum(b.prod(rD.get("quantity"), rD.get("unitPrice"))));
            q.groupBy(rP.get("id"));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        
        }
    }
    
    public List<Object[]> statsRevenueByPeriod(int year, String period){
        try(Session s = HibernateUtils.getFactory().openSession()){
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            
            Root rO = q.from(SaleOrder.class);
            Root rD = q.from(OrderDetail.class);
            q.where(b.equal(rO.get("id"), rD.get("orderId")), 
                    b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), year));
            
            q.multiselect(b.function(period, Integer.class, rO.get("createdDate")), 
                          b.sum(b.prod(rD.get("quantity"), rD.get("unitPrice"))));
            
            q.groupBy(b.function(period, Integer.class, rO.get("createdDate")));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
    
}
