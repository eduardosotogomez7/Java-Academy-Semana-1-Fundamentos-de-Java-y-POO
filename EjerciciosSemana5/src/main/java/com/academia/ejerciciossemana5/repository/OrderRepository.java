package com.academia.ejerciciossemana5.repository;

import com.academia.ejerciciossemana5.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Custom query
    List<Order> findByCustomerId(Long customerId);

}
