package com.test.CustomerApplication.controller;

import com.test.CustomerApplication.entity.Customer;
import com.test.CustomerApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /**Method to Save Customer Details*/

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    /**Method to Retrieve all the Customer Details*/

    @GetMapping("/customers")
    public List<Customer> fetchCustomerList(){
        return customerService.fetchCustomerList();
    }

    /**Method to Retrieve Customer Details by ID*/

    @GetMapping("/customers/{id}")
    public Customer fetchCustomerById(@PathVariable("id") Long id){
        return customerService.fetchCustomerById(id);
    }

}
