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
     
   }
}
