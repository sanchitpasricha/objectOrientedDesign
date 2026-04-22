package parkinglot.parkingmanager;
import java.util.*;

import parkinglot.vehicle.Vehicle;
import parkinglot.enums.VehicleSize;
import parkinglot.parkingspot.ParkingSpot;

public class ParkingManager {
   private final Map<VehicleSize, List<ParkingSpot>> availableSpots; 
   private final Map<Vehicle, ParkingSpot> vehicleToSpotMap;

   public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots){
        this.availableSpots = availableSpots;
        this.vehicleToSpotMap = new HashMap<>();
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
}
