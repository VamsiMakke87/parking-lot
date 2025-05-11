package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class CompactVehicle extends  Vehicle{


    public CompactVehicle(String licenseNumber, String ownerName) {
        super(licenseNumber, ownerName, SpotType.COMPACT);
    }

    @Override
    public double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime) {
        Duration duration= Duration.between(entryTime,exitTime);

        double hours= Math.ceil(duration.toMinutes()/60);
        return hours*10;

    }
}
