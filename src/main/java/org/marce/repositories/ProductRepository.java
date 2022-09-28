package org.marce.repositories;

import org.marce.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository {
    @Inject
    EntityManager em;

    @Transactional
    public void createProduct(Product product){
        em.persist(product);
    }

    @Transactional
    public void deleteProduct(Product product){
        em.remove(em.contains(product) ? product : em.merge(product));
    }

    @Transactional
    public List<Product> listProduct(){
        List<Product> products = em.createQuery("select p from Product p").getResultList();
        return products;
    }
    @Transactional
    public Product findProduct(Long Id){
        return em.find(Product.class, Id);
    }

    @Transactional
    public void updateProduct(Product p){
        em.merge(p);
    }
}