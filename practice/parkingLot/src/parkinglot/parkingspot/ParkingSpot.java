package practice.parkingLot.src.parkinglot.parkingspot;

import parkinglot.enums.VehicleSize;
import parkinglot.vehicle.Vehicle;

public interface ParkingSpot {
    boolean isAvailable();
    void occupy(Vehicle vehicle);
    void vacate();
    int getSpotNumber();
    VehicleSize getSize();
}
