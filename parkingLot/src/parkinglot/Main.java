package parkinglot;

import parkinglot.enums.VehicleSize;
import parkinglot.farestrategy.BaseFareStrategy;
import parkinglot.farestrategy.FareCalculator;
import parkinglot.farestrategy.PeakHoursFareStrategy;
import parkinglot.parkingmanager.ParkingManager;
import parkinglot.parkingspot.*;
import parkinglot.ticket.Ticket;
import parkinglot.vehicle.*;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<VehicleSize, List<ParkingSpot>> spots = new HashMap<>();
        spots.put(VehicleSize.SMALL, new ArrayList<>(List.of(new CompactSpot(1), new CompactSpot(2))));
        spots.put(VehicleSize.MEDIUM, new ArrayList<>(List.of(new RegularSpot(3), new RegularSpot(4))));
        spots.put(VehicleSize.LARGE, new ArrayList<>(List.of(new OversizedSpot(5))));

        ParkingManager parkingManager = new ParkingManager(spots);
        FareCalculator fareCalculator = new FareCalculator(List.of(new BaseFareStrategy(), new PeakHoursFareStrategy()));
        ParkingLot lot = new ParkingLot(parkingManager, fareCalculator);

        Vehicle car = new Car("ABC-123");
        Vehicle truck = new Truck("XYZ-789");
        Vehicle bike = new MotorCycle("MK-001");

        System.out.println("-- Parking vehicles --");
        Ticket carTicket = lot.enterVehicle(car, LocalDateTime.now().minusMinutes(90));
        Ticket truckTicket = lot.enterVehicle(truck, LocalDateTime.now().minusMinutes(45));
        Ticket bikeTicket = lot.enterVehicle(bike, LocalDateTime.now().minusMinutes(30));

        System.out.println("\n-- Leaving vehicles --");
        lot.leaveVehicle(carTicket);
        lot.leaveVehicle(truckTicket);
        lot.leaveVehicle(bikeTicket);
    }
}
