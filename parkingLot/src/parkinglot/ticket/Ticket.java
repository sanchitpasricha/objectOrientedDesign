package parkinglot.ticket;

import parkinglot.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import parkinglot.parkingspot.*;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;

    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime entryTime){
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.exitTime = null;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public LocalDateTime getEntryTime(){
        return entryTime;
    }

    public LocalDateTime getExitTime(){
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime){
        this.exitTime = exitTime;
    }

    public BigDecimal calculateParkingDuration(){
        return new BigDecimal(Duration.between(entryTime, Objects.requireNonNullElseGet(exitTime, LocalDateTime::now)).toMinutes());
    }

}
