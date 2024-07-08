package com.test.CustomerApplication.repository;

import com.test.CustomerApplication.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void saveAndFindCustomerById_SuccessScenario(){
        Customer customer = Customer.builder()
                .firstName("abc")
                .lastName("xyz")
                .dateOfBirth(new Date())
                .id(2L)
                .build();
        customerRepository.save(customer);
        Customer custFromDB = customerRepository.findById(customer.getId()).get();

        assertEquals(custFromDB.getFirstName(),"abc");

    }

    @Test
    public void whenfindAll_SuccessScenario(){
        Customer customer = Customer.builder()
                .firstName("abc")
                .lastName("xyz")
                .dateOfBirth(new Date())
                .build();
        entityManager.persist(customer);
        List<Customer> custFromDB = customerRepository.findAll();
        assertEquals(custFromDB.size(),1);

    }
}