package model;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Vehicle {

    private String licenseNumber;

    private String ownerName;

    private SpotType spotType;


    public Vehicle(String licenseNumber, String ownerName, SpotType spotType) {
        this.licenseNumber = licenseNumber;
        this.ownerName = ownerName;
        this.spotType = spotType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public  abstract double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime);

    public double getHours(LocalDateTime entryTime, LocalDateTime exitTime){
        Duration duration= Duration.between(entryTime,exitTime);

        double hours= Math.ceil(duration.toMinutes()/60.0);

        return hours;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", spotType=" + spotType +
                '}';
    }
}
