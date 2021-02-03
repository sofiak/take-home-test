package com.example.takehometest.service;

import com.example.takehometest.common.Coordinates;
import com.example.takehometest.common.Distance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistanceCalculator {
    private final DistanceConverter distanceConverter;

    public Distance getDistance(final Coordinates originCoordinates, final Coordinates destinationCoordinates) {
        double originLatitudeInRadians = Math.toRadians(originCoordinates.getLatitude());
        double originLongitudeInRadians = Math.toRadians(originCoordinates.getLongitude());
        double destinationLatitudeInRadians = Math.toRadians(destinationCoordinates.getLatitude());
        double destinationLongitudeInRadians = Math.toRadians(destinationCoordinates.getLongitude());

        double angle = Math.acos(Math.sin(originLatitudeInRadians) * Math.sin(destinationLatitudeInRadians)
                + Math.cos(originLatitudeInRadians) * Math.cos(destinationLatitudeInRadians)
                * Math.cos(originLongitudeInRadians - destinationLongitudeInRadians));

        double angleInDegrees = Math.toDegrees(angle);

        return new Distance(distanceConverter.degreesToKilometers(angleInDegrees));
    }
}
