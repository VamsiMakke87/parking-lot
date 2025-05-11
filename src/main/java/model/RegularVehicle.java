package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class RegularVehicle extends Vehicle{

    public RegularVehicle(String licenseNumber, String ownerName) {
        super(licenseNumber, ownerName, SpotType.REGULAR);
    }

    @Override
    public double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime) {
        return getHours(entryTime,entryTime)*15;
    }
}
