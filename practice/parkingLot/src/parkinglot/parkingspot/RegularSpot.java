package practice.parkingLot.src.parkinglot.parkingspot;

import parkinglot.enums.VehicleSize;
import parkinglot.vehicle.Vehicle;

public class RegularSpot implements ParkingSpot{
    private int spotNumber;
    private Vehicle vehicle;

    @Override
    public boolean isAvailable(){
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if(isAvailable()){
            this.vehicle = vehicle;
        }else{
            System.err.println("The spot is already occupied");
        }
    }

    @Override
    public void vacate(){
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber(){
        return this.spotNumber;
    }

    @Override
    public VehicleSize getSize(){
        return VehicleSize.MEDIUM;
    }
}
