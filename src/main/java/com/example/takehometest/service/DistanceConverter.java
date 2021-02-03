package com.example.takehometest.service;

import org.springframework.stereotype.Service;

@Service
public class DistanceConverter {
    private static final double nauticalMilesInADegree = 60;
    private static final double kilometersInNauticalMile = 1.852;

    public double degreesToNauticalMiles(final double distanceInDegrees) {
        return nauticalMilesInADegree * distanceInDegrees;
    }

    public double degreesToKilometers(final double distanceInDegrees) {
        return degreesToNauticalMiles(distanceInDegrees) * kilometersInNauticalMile;
    }
}
