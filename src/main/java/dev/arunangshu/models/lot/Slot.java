package dev.arunangshu.models.lot;

import dev.arunangshu.enums.VehicleType;

public class Slot {

    private final int number;

    private final VehicleType allowedVehicleType;

    private Boolean isOccupied;

    public Slot(int number, VehicleType allowedVehicleType) {
        this.number = number;
        this.allowedVehicleType = allowedVehicleType;
        this.isOccupied = false;
    }

    public int getNumber() {
        return number;
    }

    public VehicleType getAllowedVehicleType() {
        return allowedVehicleType;
    }

    public Boolean isOccupied() {
        return isOccupied;
    }

    public Boolean isFree() {
        return !isOccupied;
    }

    public void park() {
        this.isOccupied = true;
    }

    public void unpark() {
        this.isOccupied = false;
    }
}
