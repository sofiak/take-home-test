package com.example.takehometest.service;

import com.example.takehometest.common.Coordinates;
import com.example.takehometest.common.Distance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistanceHelper {
    private final DistanceCalculator distanceCalculator;

    public boolean withinDistance(final Coordinates origin, final Coordinates destination,
                                  final Distance desiredDistance) {
        Distance distance = distanceCalculator.getDistance(origin, destination);
        return distance.getKilometers() <= desiredDistance.getKilometers();
    }
}
