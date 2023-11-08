package com.somika.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list")
public class CustomerListDataAccessService implements CustomerDao {

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(
                1l,
                "Alex",
                "alex@gmail.com",
                28,
                Gender.MALE);

        Customer jamila = new Customer(
                2l,
                "Jamila",
                "jamila@gmail.com",
                19,
                Gender.MALE);
        customers.add(alex);
        customers.add(jamila);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Long id) {
        Optional<Customer> customer = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsCustomerWithEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public void deleteCustomerById(Long id) {
        Optional<Customer> customer = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
                //.ifPresent()
        if (customer.isPresent()) {
            customers.remove(customer);
        }
    }

    @Override
    public boolean existsCustomerWithId(Long id) {
        return customers.stream()
                .anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public void updateCustomer(Customer update) {
        customers.add(update);
    }
}
