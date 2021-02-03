package com.example.takehometest.repository;

import com.example.takehometest.entity.Customer;
import com.example.takehometest.utility.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = "customer.file.location=localhost")
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @MockBean
    private FileReader fileReader;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setName("Customer Name");
        when(fileReader.readLinesFromFile(any(URI.class), eq(Customer.class)))
                .thenReturn(Collections.singletonList(customer));
    }

    @Test
    void findAll() {
        List<Customer> output = customerRepository.findAll();
        verify(fileReader, times(1)).readLinesFromFile(any(URI.class), eq(Customer.class));
        Assertions.assertEquals(customer, output.get(0));
    }
}