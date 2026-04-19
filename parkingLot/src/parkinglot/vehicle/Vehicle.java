package parkinglot.vehicle;

import parkinglot.enums.VehicleSize;

public interface Vehicle {
    String getLicensePlate();
    VehicleSize getSize();
}
