package com.somika.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllCustomers();

    Optional<Customer> selectCustomerById(Long id);

    void insertCustomer(Customer customer);

    boolean existsCustomerWithEmail(String email);

    void deleteCustomerById(Long id);

    boolean existsCustomerWithId(Long id);

    void updateCustomer(Customer update);
}
