package practice.parkingLot.src.parkinglot.vehicle;
import practice.parkingLot.src.parkinglot.enums.VehicleSize;

public interface Vehicle {
    String getLicensePlate();
    VehicleSize getSize();
}
