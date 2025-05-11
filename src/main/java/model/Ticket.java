package model;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private ParkingSpot parkingSpot;

    private boolean isExpired;

    private double price;

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public Ticket(String ticketId, LocalDateTime entryTime, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }


    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public double unpark(){
        this.price=parkingSpot.unPark(this);
        this.isExpired=true;
        return price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", parkingSpot=" + parkingSpot +
                ", isExpired=" + isExpired +
                ", price=" + price +
                '}';
    }
}
