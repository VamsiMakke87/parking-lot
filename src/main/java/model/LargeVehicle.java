package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class LargeVehicle extends Vehicle{
    public LargeVehicle(String licenseNumber, String ownerName) {
        super(licenseNumber, ownerName, SpotType.LARGE);
    }

    @Override
    public double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime) {

        return getHours(entryTime,exitTime)*20;
    }
}
