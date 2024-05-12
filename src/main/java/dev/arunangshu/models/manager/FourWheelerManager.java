package dev.arunangshu.models.manager;

import dev.arunangshu.models.ParkingSpot;

import java.util.List;

public final class FourWheelerManager extends ParkingSpotManager {

    public FourWheelerManager(List<ParkingSpot> spots) {
        super(spots);
    }

    @Override
    public ParkingSpot findParkingSpace() {
        // TODO: Implementation to find nearest parking spot for Four Wheelers
        return null;
    }
}
