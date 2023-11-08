package com.somika.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class CustomerJPADataAccessServiseTest {

    private CustomerJPADataAccessServise underTest;
    private AutoCloseable autoCloseable;
    @Mock
    private CustomerRepository customerRepository;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CustomerJPADataAccessServise(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void selectAllCustomers() {
        underTest.selectAllCustomers();

        verify(customerRepository).findAll();
    }

    @Test
    void selectCustomerById() {
        Long id = 1l;
        underTest.selectCustomerById(id);

        verify(customerRepository).findById(id);
    }

    @Test
    void insertCustomer() {
        Customer customer = new Customer(
                "Ali",
                "ali@gmail.com",
                22,
                Gender.MALE);

        underTest.insertCustomer(customer);

        verify(customerRepository).save(customer);
    }

    @Test
    void existsCustomerWithEmail() {
        String email = "foo@gmail.com";

        underTest.existsCustomerWithEmail(email);

        verify(customerRepository).existsCustomerByEmail(email);
    }

    @Test
    void deleteCustomerById() {
        Long id = 1l;

        underTest.deleteCustomerById(id);

        verify(customerRepository).deleteById(id);
    }

    @Test
    void existsCustomerWithId() {
        Long id = 1l;

        underTest.existsCustomerWithId(id);

        verify(customerRepository).existsCustomerById(id);
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer(
                1l,
                "Ali",
                "ali@gmail.com",
                22,
                Gender.MALE);

        underTest.updateCustomer(customer);

        verify(customerRepository).save(customer);
    }
}