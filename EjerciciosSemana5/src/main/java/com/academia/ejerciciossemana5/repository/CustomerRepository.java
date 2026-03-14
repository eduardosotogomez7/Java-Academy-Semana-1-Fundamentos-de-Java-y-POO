package com.academia.ejerciciossemana5.repository;

import com.academia.ejerciciossemana5.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query
    Optional<Customer> findByEmail(String email);

}
