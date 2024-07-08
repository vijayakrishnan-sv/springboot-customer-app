package com.test.CustomerApplication.service;

import com.test.CustomerApplication.entity.Customer;
import com.test.CustomerApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer fetchCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
