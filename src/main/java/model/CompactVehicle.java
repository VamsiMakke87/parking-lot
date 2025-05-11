package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class CompactVehicle extends  Vehicle{


    public CompactVehicle(String licenseNumber, String ownerName) {
        super(licenseNumber, ownerName, SpotType.COMPACT);
    }

    @Override
    public double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime) {

        return getHours(entryTime,exitTime)*10;

    }
}
