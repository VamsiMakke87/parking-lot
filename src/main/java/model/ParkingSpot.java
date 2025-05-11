package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingSpot {

    private int parkingSpotId;

    private int floorNumber;

    private SpotType spotType;

    private boolean isAvailable;

    private Vehicle vehicle;


    public ParkingSpot(int parkingSpotId, int floorNumber, SpotType spotType) {
        this.parkingSpotId = parkingSpotId;
        this.floorNumber = floorNumber;
        this.spotType = spotType;
        this.isAvailable= true;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Ticket park(){
        this.isAvailable=false;
        return  new Ticket(UUID.randomUUID().toString(), LocalDateTime.now(), this);
    }

    public double unPark(Ticket t){
        this.isAvailable=true;
        return vehicle.calculateAmount(t.getEntryTime(),t.getExitTime());
    }

    @Override
    public String toString() {
        return "{" +
                "parkingSpotId=" + parkingSpotId +
                ", floorNumber=" + floorNumber +
                ", spotType=" + spotType +
                '}';
    }
}
