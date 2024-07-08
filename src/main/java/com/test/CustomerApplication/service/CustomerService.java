package com.test.CustomerApplication.service;

import com.test.CustomerApplication.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer( Customer customer);
    List<Customer> fetchCustomerList();

    Customer fetchCustomerById(Long id);
}
