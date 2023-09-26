package com.somika.customer;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository not needed
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsCustomerByEmail(String email);
    boolean existsCustomerById(Long id);
}
