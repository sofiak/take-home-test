package com.example.takehometest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DistanceConverterTest {
    private DistanceConverter unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = new DistanceConverter();
    }

    @Test
    void testDegreesToNauticalMiles() {
        double nauticalMiles = unitUnderTest.degreesToNauticalMiles(12);
        Assertions.assertEquals(720, nauticalMiles);
    }

    @Test
    void testdegreesToKilometers() {
        double kilometers = unitUnderTest.degreesToKilometers(12);
        Assertions.assertEquals(1333.44, kilometers);
    }
}