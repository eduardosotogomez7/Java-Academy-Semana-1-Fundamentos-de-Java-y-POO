package com.academia.ejerciciossemana5.service;

import com.academia.ejerciciossemana5.entity.Customer;
import com.academia.ejerciciossemana5.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldReturnAllCustomers() {

        List<Customer> customers = List.of(new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getAllCustomers();

        assertEquals(2, result.size());
    }

    @Test
    void shouldReturnCustomerWhenIdExists() {

        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.getCustomerById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void shouldCreateCustomer() {

        Customer customer = new Customer();
        customer.setName("Juan");

        when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = customerService.createCustomer(customer);

        assertEquals("Juan", result.getName());
    }

    @Test
    void shouldDeleteCustomer() {

        Long id = 1L;

        customerService.deleteCustomer(id);

        verify(customerRepository).deleteById(id);
    }
}
