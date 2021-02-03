package com.example.takehometest.repository;

import com.example.takehometest.utility.FileReader;
import com.example.takehometest.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerRepository {
    private final FileReader fileReader;

    @Value("${customer.file.location}")
    private String fileLocation;

    public List<Customer> findAll() {
        return readCustomersFromFile();
    }

    private List<Customer> readCustomersFromFile() {
        URI uri = URI.create(fileLocation);
        return fileReader.readLinesFromFile(uri, Customer.class);
    }
}
