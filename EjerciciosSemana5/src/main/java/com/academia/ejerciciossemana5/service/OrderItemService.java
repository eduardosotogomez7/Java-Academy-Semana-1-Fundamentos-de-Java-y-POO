package com.academia.ejerciciossemana5.service;

import com.academia.ejerciciossemana5.entity.OrderItem;
import com.academia.ejerciciossemana5.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem createItem(OrderItem item) {
        return orderItemRepository.save(item);
    }

    public void deleteItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}