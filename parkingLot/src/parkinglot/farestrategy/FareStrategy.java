package parkinglot.farestrategy;

import java.math.BigDecimal;
import parkinglot.ticket.*;

public interface FareStrategy {
    BigDecimal calculateFare(Ticket ticket, BigDecimal inputFare);
}
