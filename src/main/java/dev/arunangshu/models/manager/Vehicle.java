package dev.arunangshu.models.manager;

import dev.arunangshu.enums.VehicleType;

public class Vehicle {

    private final VehicleType type;

    private final String registrationNumber;

    private final String color;

    public Vehicle(VehicleType type, String registrationNumber, String color) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getColor() {
        return this.color;
    }
}
