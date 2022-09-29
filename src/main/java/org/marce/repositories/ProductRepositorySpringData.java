package org.marce.repositories;

import org.marce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepositorySpringData extends JpaRepository<Product,Long> {
}