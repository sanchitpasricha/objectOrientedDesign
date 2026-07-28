package practice.parkingLot.src.parkinglot.parkingspot;

import parkinglot.enums.VehicleSize;
import parkinglot.vehicle.Vehicle;

public class CompactSpot implements ParkingSpot{
    private int spotNumber;
    private Vehicle vehicle;

    public CompactSpot(int spotNumber){
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public boolean isAvailable(){
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle){
        if(isAvailable()){
            this.vehicle = vehicle;
        }else{
            System.out.println("The spot is not available");
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
        return VehicleSize.SMALL;
    }


}
