package com.example.takehometest.service;

import com.example.takehometest.common.Coordinates;
import com.example.takehometest.common.Distance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DistanceHelperTest {

    private DistanceHelper unitUnderTest;
    private DistanceCalculator distanceCalculator;
    private Distance desiredDistance = new Distance( 100.00 );

    @BeforeEach
    void setUp() {
        distanceCalculator = mock(DistanceCalculator.class);
        unitUnderTest = new DistanceHelper(distanceCalculator);
    }

    @Test
    void withinDistance() {
        Distance distance = new Distance(99);
        when(distanceCalculator.getDistance(any(Coordinates.class), any(Coordinates.class)))
                .thenReturn(distance);

        Assertions.assertTrue(unitUnderTest.withinDistance(new Coordinates(), new Coordinates(), desiredDistance));
    }

    @Test
    void withinDistanceWhenNotInDistance() {
        Distance distance = new Distance(218);
        when(distanceCalculator.getDistance(any(Coordinates.class), any(Coordinates.class)))
                .thenReturn(distance);

        Assertions.assertFalse(unitUnderTest.withinDistance(new Coordinates(), new Coordinates(), desiredDistance));
    }
}