package dev.arunangshu.models;

import dev.arunangshu.enums.VehicleType;
import dev.arunangshu.models.manager.ParkingSpotManager;
import dev.arunangshu.models.manager.ParkingSpotManagerFactory;

import java.util.List;

public class EntranceGate {

    private final ParkingSpotManagerFactory factory;

    public EntranceGate(ParkingSpotManagerFactory factory) {
        this.factory = factory;
    }

    public ParkingSpot findParkingSpace(VehicleType vehicleType, List<ParkingSpot> spots) {
        ParkingSpotManager manager = factory.getParkingSpotManager(vehicleType, spots);
        return manager.findParkingSpace();
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        // Implementation to generate ticket
        return null;
    }
}
