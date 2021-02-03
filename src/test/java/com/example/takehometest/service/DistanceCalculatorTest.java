package com.example.takehometest.service;

import com.example.takehometest.common.Coordinates;
import com.example.takehometest.common.Distance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;

@ExtendWith(MockitoExtension.class)
class DistanceCalculatorTest {

    private DistanceCalculator unitUnderTest;

    @BeforeEach
    void setUp() {
        DistanceConverter distanceConverter = new DistanceConverter();
        unitUnderTest = new DistanceCalculator(distanceConverter);
    }

    @Test
    void getDistance() {
        Coordinates origin = new Coordinates(12.4, 13.3);
        Coordinates destination = new Coordinates(14.5, 12.7);
        Distance expectedDistance = new Distance(242.19262894512448);
        Distance output = unitUnderTest.getDistance(origin, destination);

        Assertions.assertEquals(expectedDistance.getKilometers(), output.getKilometers());
    }
}