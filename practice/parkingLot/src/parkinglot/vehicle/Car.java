package practice.parkingLot.src.parkinglot.vehicle;
import practice.parkingLot.src.parkinglot.enums.VehicleSize;

public class Car implements Vehicle{
    private String licensePlate;

    public Car(String licensePlate){
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate(){
        return this.licensePlate;
    }

    @Override
    public VehicleSize getSize(){
        return VehicleSize.MEDIUM;
    }
}
