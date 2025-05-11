package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {

    private int floorNumber;


    private Map<SpotType, List<ParkingSpot>> parkingSpots;

    public Floor(int floorNumber){
        this.floorNumber= floorNumber;
        this.parkingSpots= new HashMap<>();
        parkingSpots.put(SpotType.COMPACT, new ArrayList<>());
        parkingSpots.put(SpotType.REGULAR, new ArrayList<>());
        parkingSpots.put(SpotType.LARGE, new ArrayList<>());
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpots.get(parkingSpot.getSpotType()).add(parkingSpot);
    }

    public List<ParkingSpot> getAvailableParkingSpots(SpotType spotType){

        List<ParkingSpot> availableParkingSpots= new ArrayList<>();

        for(ParkingSpot parkingSpot: parkingSpots.get(spotType) ){
            if(parkingSpot.isAvailable()){
                availableParkingSpots.add(parkingSpot);
            }
        }

        return  availableParkingSpots;
    }




}
