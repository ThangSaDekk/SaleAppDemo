/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.repository.impl;

import com.nvt.hibernatedemo.HibernateUtils;
import com.nvt.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {

    private static final int PAGE_SIZE = 4;

    public List<Product> getProducts(Map<String, String> params) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);

            List<Predicate> predicates = new ArrayList<>();

            if (params != null) {
                String kw = params.get("kw");
                String fromPrice = params.get("fromPrice");
                String toPrice = params.get("toPrice");
                String category = params.get("category");
                if (kw != null && !kw.isEmpty()) {
                    predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
                }
                if (fromPrice != null && !fromPrice.isEmpty()) {
                    predicates.add(b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice)));
                }
                if (toPrice != null && !toPrice.isEmpty()) {
                    predicates.add(b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice)));
                }
                if (category != null && !category.isEmpty()) {
                    predicates.add(b.equal(root.get("category"), Integer.parseInt(category)));
                }
            }

            q.where(predicates.toArray(Predicate[]::new));
            q.orderBy(b.desc(root.get("id")));
            Query query = s.createQuery(q);
            if (params != null) {
                String page = params.get("page");
                if (page != null && !params.isEmpty()) {
                    int start = (Integer.parseInt(page) - 1) * PAGE_SIZE;
                    query.setFirstResult(start);
                    query.setMaxResults(PAGE_SIZE);
                }
            }

            return query.getResultList();
        }

    }

    public void addOrUpdate(Product p) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            if (p.getId() != null) {
                s.update(p);
            } else {
                s.save(p);
            }
        }
    }

    public Product getProductById(int id) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            return s.get(Product.class, id);
        }
    }
}
