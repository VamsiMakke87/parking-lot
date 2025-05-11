package model;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;

    private LocalDateTime entryTime;

    private ParkingSpot parkingSpot;

    private boolean isExpired;

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

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", entryTime=" + entryTime +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}
