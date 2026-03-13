package com.academia.ejerciciossemana5.repository;

import com.academia.ejerciciossemana5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategory(String category);

    List<Product> findByInStock(boolean inStock);

    List<Product> findByPriceGreaterThan(java.math.BigDecimal price);


}
