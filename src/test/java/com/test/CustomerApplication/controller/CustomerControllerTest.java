package com.test.CustomerApplication.controller;

import com.test.CustomerApplication.entity.Customer;
import com.test.CustomerApplication.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc  mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = Customer.builder().id(1L)
                .firstName("abc")
                .lastName("xyz")
                .dateOfBirth(new Date())
                .build();
    }

    @Test
    public void saveCustomerTest() throws Exception {
        Customer input = Customer.builder().firstName("abc").lastName("xyz").dateOfBirth(new Date()).id(1L).build();
        Mockito.when(customerService.saveCustomer(input)).thenReturn(customer);
        String json = "{\n" +
                "    \n" +
                "    \"firstName\": \"abc\",\n" +
                "    \"lastName\": \"xyz\",\n" +
                "    \"dateOfBirth\": \"2023-03-06\"\n" +
                "}";
        mockMvc.perform(post("/customers").contentType(MediaType.APPLICATION_JSON).content(json))

                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void fetchCustomerListTest() throws Exception {
        Customer input = Customer.builder().firstName("abc").lastName("xyz").dateOfBirth(new Date()).id(1L).build();
        List<Customer> custList = Collections.singletonList(customer);
        Mockito.when(customerService.fetchCustomerList()).thenReturn(custList);
        mockMvc.perform(get("/customers")).andExpect(status().isOk());
    }

    @Test
    public void fetchCustomerByIdTest() throws Exception {
        Customer input = Customer.builder().firstName("abc").lastName("xyz").dateOfBirth(new Date()).id(1L).build();
        Mockito.when(customerService.fetchCustomerById(1L)).thenReturn(customer);
        mockMvc.perform(MockMvcRequestBuilders.get("/customers/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}