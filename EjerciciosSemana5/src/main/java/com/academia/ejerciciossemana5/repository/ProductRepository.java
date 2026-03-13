package com.academia.ejerciciossemana5.repository;

// Create a Spring Data JPA repository interface called ProductRepository.
// It should extend JpaRepository for the Product entity with Long as ID.
// Add three custom query methods:
// - findByCategory(String category)
// - findByInStock(boolean inStock)
// - findByPriceGreaterThan(BigDecimal price)

import com.academia.ejerciciossemana5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByInStock(boolean inStock);
    List<Product> findByPriceGreaterThan(BigDecimal price);
}




