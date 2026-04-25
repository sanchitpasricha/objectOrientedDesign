package parkinglot;

import parkinglot.farestrategy.FareCalculator;
import parkinglot.parkingmanager.ParkingManager;
import parkinglot.parkingspot.ParkingSpot;
import parkinglot.ticket.Ticket;
import parkinglot.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingLot {
    private final ParkingManager parkingManager;
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    public Ticket enterVehicle(Vehicle vehicle) {
        return enterVehicle(vehicle, LocalDateTime.now());
    }

    public Ticket enterVehicle(Vehicle vehicle, LocalDateTime entryTime) {
        ParkingSpot spot = parkingManager.parkVehicle(vehicle);

        if (spot != null) {
            Ticket ticket = new Ticket(generateTicketId(), vehicle, spot, entryTime);
            return ticket;
        } else {
            System.out.println("No available spots for vehicle: " + vehicle.getLicensePlate());
            return null;
        }
    }

    public void leaveVehicle(Ticket ticket) {
        if (ticket != null && ticket.getExitTime() == null) {
            ticket.setExitTime(LocalDateTime.now());
            parkingManager.unparkVehicle(ticket.getVehicle());
            BigDecimal fare = fareCalculator.calculateFare(ticket);
            System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() + " has left. Total fare: $" + fare);
        } else {
            System.out.println("Invalid ticket or vehicle already exited.");
        }
    }

    private String generateTicketId() {
        return UUID.randomUUID().toString();
    }
}
