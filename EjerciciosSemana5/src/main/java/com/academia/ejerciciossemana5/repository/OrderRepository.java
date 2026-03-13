package com.academia.ejerciciossemana5.repository;

import com.academia.ejerciciossemana5.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(String customer);

    @Query("SELECT SUM(o.total) FROM Order o")
    Double getTotalRevenue();

}
