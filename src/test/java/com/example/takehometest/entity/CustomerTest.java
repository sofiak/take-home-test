package com.example.takehometest.entity;

import com.example.takehometest.common.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void getLocation() {
        double latitude = 5.67;
        double longitude = 1.96;
        Customer customer = new Customer();
        customer.setLatitude(latitude);
        customer.setLongitude(longitude);
        Coordinates customerLocation = customer.getLocation();
        Assertions.assertEquals(latitude, customerLocation.getLatitude());
        Assertions.assertEquals(longitude, customerLocation.getLongitude());
    }

    @Test
    void compareTo() {
        Customer customerWithSmallerId = new Customer();
        customerWithSmallerId.setUserId(10L);
        Customer customerWithHigherId = new Customer();
        customerWithHigherId.setUserId(234L);
        Assertions.assertEquals(-1, customerWithSmallerId.compareTo(customerWithHigherId));
    }

    @Test
    void testToString() {
        String customerName = "Customer Name";
        long customerId = 13L;
        Customer customer = new Customer();
        customer.setUserId(customerId);
        customer.setName(customerName);
        String expectedToString = String.format("Customer name: %s, id: %s", customerName, customerId);

        Assertions.assertEquals(expectedToString, customer.toString());
    }
}