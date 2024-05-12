package dev.arunangshu.models.manager;

import dev.arunangshu.models.lot.Floor;
import dev.arunangshu.models.lot.ParkingLot;
import dev.arunangshu.models.lot.Slot;

public class Ticket {

    private final String id;

    private final ParkingLot parkingLot;

    private final Floor floor;

    private final Slot slot;

    private final Vehicle vehicle;

    public Ticket(ParkingLot parkingLot, Floor floor, Slot slot, Vehicle vehicle) {
        this.id = parkingLot.getId() + "_" + floor.getNumber() + "_" + slot.getNumber();
        this.parkingLot = parkingLot;
        this.floor = floor;
        this.slot = slot;
        this.vehicle = vehicle;
    }

    public String getId() {
        return id;
    }

    public Slot getSlot() {
        return this.slot;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }
}
