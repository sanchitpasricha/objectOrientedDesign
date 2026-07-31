package practice.parkingLot.src.parkinglot.farestrategy;

import java.math.BigDecimal;
import parkinglot.ticket.Ticket;

public interface FareStrategy {
    BigDecimal calculateFare(Ticket ticket, BigDecimal inputFare);
}
