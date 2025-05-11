package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class LargeVehicle extends Vehicle{
    public LargeVehicle(String licenseNumber, String ownerName) {
        super(licenseNumber, ownerName, SpotType.LARGE);
    }

    @Override
    public double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime) {
        Duration duration= Duration.between(entryTime,exitTime);

        double hours= Math.ceil(duration.toMinutes()/60);
        return hours*20;
    }
}
