package dev.arunangshu.models.manager;

import dev.arunangshu.enums.VehicleType;
import dev.arunangshu.models.lot.Floor;
import dev.arunangshu.models.lot.ParkingLot;
import dev.arunangshu.models.lot.Slot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingManager {

    public final ParkingLot parkingLot;

    private final Map<String, Ticket> tickets = new HashMap<>();

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void parkVehicle(VehicleType vehicleType, String registrationNumber, String color) {
        Vehicle vehicle = new Vehicle(vehicleType, registrationNumber, color);
        List<Floor> floors = parkingLot.getFloors();

        for (Floor floor : floors) {
            Optional<Slot> slotOptional = floor.findSlot(vehicleType);

            if (slotOptional.isPresent()) {
                Slot slot = slotOptional.get();
                slot.park();
                Ticket ticket = new Ticket(this.parkingLot, floor, slot, vehicle);
                this.tickets.put(ticket.getId(), ticket);
                System.out.println("Parked vehicle. Ticket ID: " + ticket.getId());
                return;
            }
        }
        System.out.println("Parking full. Vehicle cannot be parked.");
    }

    public void unparkVehicle(String ticketId) {
        Ticket ticket = this.tickets.remove(ticketId);

        if (ticket == null) {
            System.out.println("Invalid Ticket");
            return;
        }

        ticket.getSlot().unpark();
        System.out.println(
                "Unparked vehicle with Registration Number: "
                        + ticket.getVehicle().getRegistrationNumber()
                        + " and Color: "
                        + ticket.getVehicle().getColor());
    }
}
