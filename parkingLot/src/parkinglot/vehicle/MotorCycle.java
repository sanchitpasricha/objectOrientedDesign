package parkinglot.vehicle;
import parkinglot.enums.VehicleSize;

public class MotorCycle implements Vehicle{
    private String licensePlate;

    public MotorCycle(String licencePlate){
        this.licensePlate = licencePlate;
    }

    @Override
    public String getLicensePlate(){
        return this.licensePlate;
    }

    @Override
    public VehicleSize getSize(){
        return VehicleSize.SMALL;
    }
}
