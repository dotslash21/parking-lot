package dev.arunangshu.models.manager;

import dev.arunangshu.models.ParkingSpot;

import java.util.List;

public final class TwoWheelerManager extends ParkingSpotManager {

    public TwoWheelerManager(List<ParkingSpot> spots) {
        super(spots);
    }

    @Override
    public ParkingSpot findParkingSpace() {
        // TODO: Implementation to find nearest parking spot for Two Wheelers
        return null;
    }
}

