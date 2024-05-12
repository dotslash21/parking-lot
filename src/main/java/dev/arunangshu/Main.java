package dev.arunangshu;

import dev.arunangshu.enums.VehicleType;
import dev.arunangshu.models.lot.ParkingLot;

import java.util.Scanner;

public class Main {

    public static void inputLoop() {
        Scanner scanner = new Scanner(System.in);

        ParkingLot parkingLot = null;

        boolean continueLoop = true;
        while (continueLoop) {
            String command = scanner.next();
            switch (command) {
                case "create_parking_lot": {
                    String parkingLotId = scanner.next();
                    int numFloors = scanner.nextInt();
                    int numSlotsPerFloor = scanner.nextInt();
                    if (parkingLot != null) {
                        System.out.println("Parking lot already exists!");
                        break;
                    }
                    parkingLot = new ParkingLot(parkingLotId, numFloors, numSlotsPerFloor);
                    break;
                }

                case "park_vehicle": {
                    if (parkingLot == null) {
                        System.out.println("Parking lot does not exist!");
                        break;
                    }
                    VehicleType vehicleType = VehicleType.valueOf(scanner.next());
                    String vehicleRegistrationNumber = scanner.next();
                    String vehicleColor = scanner.next();
                    parkingLot.getParkingManager().parkVehicle(vehicleType, vehicleRegistrationNumber, vehicleColor);
                    break;
                }

                case "unpark_vehicle": {
                    if (parkingLot == null) {
                        System.out.println("Parking lot does not exist!");
                        break;
                    }
                    String registrationNumber = scanner.next();
                    parkingLot.getParkingManager().unparkVehicle(registrationNumber);
                    break;
                }

                case "display": {
                    if (parkingLot == null) {
                        System.out.println("Parking lot does not exist!");
                        break;
                    }
                    String displayType = scanner.next();
                    switch (displayType) {
                        case "free_count": {
                            VehicleType vehicleType = VehicleType.valueOf(scanner.next());
                            parkingLot.displayFreeSlotsCount(vehicleType);
                            break;
                        }

                        case "free_slots": {
                            VehicleType vehicleType = VehicleType.valueOf(scanner.next());
                            parkingLot.displayFreeSlots(vehicleType);
                            break;
                        }

                        case "occupied_slots": {
                            VehicleType vehicleType = VehicleType.valueOf(scanner.next());
                            parkingLot.displayOccupiedSlots(vehicleType);
                            break;
                        }

                        default:
                            System.out.println("Incorrect display type provided!");
                    }
                    break;
                }

                case "exit":
                    continueLoop = false;
                    break;

                default:
                    System.out.println("Incorrect command provided!");
            }
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        inputLoop();
    }
}