package com.academia.ejerciciossemana5.repository;

import com.academia.ejerciciossemana5.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // Custom query
    List<OrderItem> findByProductName(String productName);

}