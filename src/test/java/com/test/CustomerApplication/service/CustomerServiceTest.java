package com.test.CustomerApplication.service;

import com.test.CustomerApplication.entity.Customer;
import com.test.CustomerApplication.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    CustomerService customerService;
    Customer customer;

    @MockBean
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
         customer = Customer.builder().id(1L)
                .firstName("abc")
                .lastName("xyz")
                .dateOfBirth(new Date())
                .build();
    }

    @Test
    public void saveCustomer() {
        Mockito.when(customerRepository.save(any())).thenReturn(customer);
        Customer cust = customerService.saveCustomer(customer);
        assertNotNull(cust);
        assertEquals(cust.getFirstName(),"abc");
    }

    @Test
    public void fetchCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        Mockito.when(customerRepository.findAll()).thenReturn(customerList);
        List<Customer> cust = customerService.fetchCustomerList();
        assertNotNull(cust);
        assertEquals(cust.size(),1);
    }

    @Test
    public void fetchCustomerById() {
        Mockito.when(customerRepository.findById(any())).thenReturn(Optional.of(customer));
        Customer cust = customerService.fetchCustomerById(1L);
        assertNotNull(cust);
        assertEquals(cust.getFirstName(),"abc");
    }
}