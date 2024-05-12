package dev.arunangshu.models.lot;

import dev.arunangshu.enums.VehicleType;
import dev.arunangshu.models.manager.ParkingManager;

import java.util.*;

public class ParkingLot {

    private final String id;

    private final List<Floor> floors = new ArrayList<>();

    private final ParkingManager parkingManager;

    public ParkingLot(String id, int numFloors, int numSlotsPerFloor) {
        this.id = id;

        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i + 1, numSlotsPerFloor));
        }

        this.parkingManager = new ParkingManager(this);

        System.out.println(
                "Created parking lot with "
                        + numFloors
                        + " floors and "
                        + numSlotsPerFloor
                        + " slots per floor");
    }

    public String getId() {
        return id;
    }

    public List<Floor> getFloors() {
        return this.floors;
    }

    public ParkingManager getParkingManager() {
        return this.parkingManager;
    }

    public void displayFreeSlotsCount() {
        for (Floor floor : floors) {
            floor.displayFreeSlotsCount();
        }
    }

    public void displayFreeSlotsCount(VehicleType vehicleType) {
        for (Floor floor : floors) {
            floor.displayFreeSlotsCount(vehicleType);
        }
    }

    public void displayFreeSlots() {
        for (Floor floor : floors) {
            floor.displayFreeSlots();
        }
    }

    public void displayFreeSlots(VehicleType vehicleType) {
        for (Floor floor : floors) {
            floor.displayFreeSlots(vehicleType);
        }
    }

    public void displayOccupiedSlots() {
        for (Floor floor : floors) {
            floor.displayOccupiedSlots();
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType) {
        for (Floor floor : floors) {
            floor.displayOccupiedSlots(vehicleType);
        }
    }
}
