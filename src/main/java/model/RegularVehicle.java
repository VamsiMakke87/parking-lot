package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class RegularVehicle extends Vehicle{

    public RegularVehicle(String licenseNumber, String ownerName) {
        super(licenseNumber, ownerName, SpotType.REGULAR);
    }

    @Override
    public double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime) {
        Duration duration= Duration.between(entryTime,exitTime);

        double hours= Math.ceil(duration.toMinutes()/60);
        return hours*15;
    }
}
