package practice.parkingLot.src.parkinglot.parkingmanager;
import java.util.*;

import parkinglot.enums.VehicleSize;
import parkinglot.parkingspot.ParkingSpot;
import parkinglot.vehicle.Vehicle;

public class ParkingManager {
    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicleToSpot;
    
    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots){
        this.availableSpots = availableSpots; 
        this.vehicleToSpot = new HashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
        VehicleSize vehicleSize = vehicle.getSize();
        for(VehicleSize size : VehicleSize.values()){
            if(size.ordinal() >= vehicleSize.ordinal()){
                List<ParkingSpot> spots = availableSpots.get(size);
                for(ParkingSpot spot : spots){
                    if(spot.isAvailable()){
                        return spot;
                    }
                }
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findSpotForVehicle(vehicle);
        if(spot != null){
            spot.occupy(vehicle);
            vehicleToSpot.put(vehicle, spot);
            availableSpots.get(spot.getSize()).remove(spot);
        }
        return spot;
    }

    public void unparkVehicle(Vehicle vehicle){
        ParkingSpot spot = vehicleToSpot.remove(vehicle);
        if(spot != null){
            spot.vacate();
            availableSpots.get(spot.getSize()).add(spot);
        }
    }
}
