package com.somika.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository not needed
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsCustomerByEmail(String email);

    boolean existsCustomerById(Long id);

    Optional<Customer> findCustomerByEmail(String email);
}
