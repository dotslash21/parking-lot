package dev.arunangshu.models.manager;

import dev.arunangshu.enums.VehicleType;
import dev.arunangshu.models.ParkingSpot;

import java.util.List;

public class ParkingSpotManagerFactory {

    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType, List<ParkingSpot> spots) {
        if (vehicleType == VehicleType.TWO_WHEELER)
            return new TwoWheelerManager(spots);
        else if (vehicleType == VehicleType.FOUR_WHEELER)
            return new FourWheelerManager(spots);
        else
            return null; // Handle error
    }
}
