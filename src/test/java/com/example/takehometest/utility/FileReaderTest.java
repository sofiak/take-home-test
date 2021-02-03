package com.example.takehometest.utility;

import com.example.takehometest.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class FileReaderTest {
    private FileReader unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = new FileReader();
    }

    @Test
    void readLinesFromFile() {
        File inputFile = new File("src/test/resources/test-customers.txt");

        List<Customer> customerList = unitUnderTest.readLinesFromFile(inputFile.toURI(), Customer.class);

        Assertions.assertEquals(32, customerList.size());
    }
}