package com.academia.ejerciciossemana5.service;

// Create a Spring service class called ProductService.
// It should use ProductRepository with dependency injection.
// Implement basic CRUD operations:
// createProduct(Product product)
// getAllProducts()
// getProductById(Long id)
// updateProduct(Product product)
// deleteProduct(Long id)
// Also implement findByCategory(String category).

import com.academia.ejerciciossemana5.entity.Product;
import com.academia.ejerciciossemana5.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}








