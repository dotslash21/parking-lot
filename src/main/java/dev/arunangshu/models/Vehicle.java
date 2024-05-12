package dev.arunangshu.models;

import dev.arunangshu.enums.VehicleType;

public record Vehicle(int registrationNumber, VehicleType type) {
}
