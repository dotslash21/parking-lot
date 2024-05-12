package dev.arunangshu.models;

import dev.arunangshu.models.manager.ParkingSpotManager;
import dev.arunangshu.models.manager.ParkingSpotManagerFactory;

import java.util.ArrayList;

public class ExitGate {

    private final ParkingSpotManagerFactory factory;

    public ExitGate(ParkingSpotManagerFactory factory) {
        this.factory = factory;
    }

    public void removeVehicle(Ticket ticket) {
        ParkingSpotManager manager = factory.getParkingSpotManager(ticket.vehicle().type(), new ArrayList<>());
        manager.removeVehicle(ticket.vehicle());
    }
}
