package dev.arunangshu.models.lot;

import dev.arunangshu.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Floor {

    private final int number;

    private final List<Slot> slots = new ArrayList<>();

    public Floor(int floorNumber, int numSlots) {
        this.number = floorNumber;

        if (numSlots > 1) {
            slots.add(new Slot(1, VehicleType.TRUCK));
            numSlots--;
        }

        if (numSlots > 2) {
            slots.add(new Slot(2, VehicleType.BIKE));
            slots.add(new Slot(3, VehicleType.BIKE));
            numSlots -= 2;
        }

        for (int i = 0; i < numSlots; i++) {
            slots.add(new Slot(i + 4, VehicleType.CAR));
        }
    }

    public int getNumber() {
        return number;
    }

    public Integer getFreeSlotsCount() {
        return (int) slots.stream().filter(Slot::isFree).count();
    }

    public Map<VehicleType, Long> getFreeSlotsCountGroupByVehicleType() {
        return slots.stream()
                .filter(Slot::isFree)
                .collect(Collectors.groupingBy(Slot::getAllowedVehicleType, Collectors.counting()));
    }

    public Integer getOccupiedSlotsCount() {
        return (int) slots.stream().filter(Slot::isOccupied).count();
    }

    public List<Slot> getFreeSlots() {
        return slots.stream().filter(Slot::isFree).toList();
    }

    public Map<VehicleType, List<Slot>> getFreeSlotsGroupByVehicleType() {
        return slots.stream()
                .filter(Slot::isFree)
                .collect(Collectors.groupingBy(Slot::getAllowedVehicleType));
    }

    public List<Slot> getOccupiedSlots() {
        return slots.stream().filter(Slot::isOccupied).toList();
    }

    public void displayFreeSlotsCount() {
        Map<VehicleType, Long> getFreeSlotsCountGroupByVehicleType = this.getFreeSlotsCountGroupByVehicleType();
        for (Map.Entry<VehicleType, Long> entry : getFreeSlotsCountGroupByVehicleType.entrySet()) {
            System.out.println(
                    "No. of free slots for "
                            + entry.getKey()
                            + " on Floor "
                            + this.getNumber()
                            + ": "
                            + entry.getValue());
        }
    }

    public void displayFreeSlotsCount(VehicleType vehicleType) {
        long freeSlotsCount = this.slots
                .stream()
                .filter(Slot::isFree)
                .filter(slot -> slot.getAllowedVehicleType() == vehicleType)
                .count();
        System.out.println("No. of free slots for " + vehicleType + " on Floor " + this.getNumber() + ": " + freeSlotsCount);
    }

    public void displayFreeSlots() {
        Map<VehicleType, List<Slot>> getFreeSlotsGroupByVehicleType = this.getFreeSlotsGroupByVehicleType();
        for (Map.Entry<VehicleType, List<Slot>> entry : getFreeSlotsGroupByVehicleType.entrySet()) {
            String slotsCsv = entry.getValue()
                    .stream()
                    .map(Slot::getNumber)
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println("Free slots for " + entry.getKey() + " on Floor " + this.getNumber() + ": " + slotsCsv);
        }
    }

    public void displayFreeSlots(VehicleType vehicleType) {
        List<Slot> freeSlots = this.slots
                .stream()
                .filter(Slot::isFree)
                .filter(slot -> slot.getAllowedVehicleType() == vehicleType)
                .toList();
        String slotsCsv = freeSlots
                .stream()
                .map(Slot::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println("Free slots for " + vehicleType + " on Floor " + this.getNumber() + ": " + slotsCsv);
    }

    public void displayOccupiedSlots() {
        List<Slot> occupiedSlots = this.getOccupiedSlots();
        String slotsCsv = occupiedSlots
                .stream()
                .map(Slot::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println("Occupied slots on Floor " + this.getNumber() + ": " + slotsCsv);
    }

    public void displayOccupiedSlots(VehicleType vehicleType) {
        List<Slot> occupiedSlots = this.slots
                .stream()
                .filter(Slot::isOccupied)
                .filter(slot -> slot.getAllowedVehicleType() == vehicleType)
                .toList();
        String slotsCsv = occupiedSlots
                .stream()
                .map(Slot::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println("Occupied slots for " + vehicleType + " on Floor " + this.getNumber() + ": " + slotsCsv);
    }

    public Optional<Slot> findSlot(VehicleType vehicleType) {
        return slots
                .stream()
                .filter(Slot::isFree)
                .filter(slot -> slot.getAllowedVehicleType() == vehicleType)
                .findFirst();
    }
}
