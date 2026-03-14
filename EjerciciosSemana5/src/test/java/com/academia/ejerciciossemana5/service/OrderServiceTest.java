package com.academia.ejerciciossemana5.service;

import com.academia.ejerciciossemana5.entity.Order;
import com.academia.ejerciciossemana5.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    public OrderServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnOrderWhenIdExists() {

        Order order = new Order();
        order.setId(1L);

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.getOrderById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void shouldDeleteOrder() {

        Long id = 1L;

        orderService.deleteOrder(id);

        verify(orderRepository).deleteById(id);
    }

    @Test
    void shouldSaveOrder() {

        Order order = new Order();
        order.setId(1L);

        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.createOrder(order);

        assertEquals(1L, result.getId());
    }



    @Test
    void shouldReturnAllOrders() {

        List<Order> orders = List.of(new Order(), new Order());

        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.getAllOrders();

        assertEquals(2, result.size());
    }

    @Test
    void shouldCreateOrder() {

        Order order = new Order();
        order.setId(1L);

        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.createOrder(order);

        assertEquals(1L, result.getId());
    }

}
