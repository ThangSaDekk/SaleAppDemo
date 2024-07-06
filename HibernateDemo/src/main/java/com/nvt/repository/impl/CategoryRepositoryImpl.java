/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.repository.impl;

import com.nvt.hibernatedemo.HibernateUtils;
import com.nvt.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class CategoryRepositoryImpl {
   public List<Category> getCategory(){
       try(Session s = HibernateUtils.getFactory().openSession()){
           Query q = s.createQuery("FROM Category");
           return q.getResultList();
       }
   }
}
