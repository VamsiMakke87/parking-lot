package service;

import model.Floor;
import model.ParkingSpot;
import model.SpotType;
import model.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotApplication {


    private static ParkingLotApplication instance;
    private  Map<Integer,Floor> floors;

    private Map<String, Ticket> tickets= new HashMap<>();


    private ParkingLotApplication(){}

    public static ParkingLotApplication getInstance(){
        if(instance==null){
            instance= new ParkingLotApplication();
        }

        return  instance;
    }



    public void initalise() {
        Floor floor1= new Floor(1);
        Floor floor2= new Floor(2);
        Floor floor3= new Floor(3);

        floors= new HashMap<>();

        floors.put(1,floor1);
        floors.put(2,floor2);
        floors.put(3,floor3);

        ParkingSpot parkingSpot1= new ParkingSpot(101,1, SpotType.COMPACT);
        ParkingSpot parkingSpot2= new ParkingSpot(102,1, SpotType.COMPACT);
        ParkingSpot parkingSpot3= new ParkingSpot(103,1, SpotType.REGULAR);
        ParkingSpot parkingSpot4= new ParkingSpot(104,1, SpotType.LARGE);
        ParkingSpot parkingSpot5= new ParkingSpot(201,2, SpotType.COMPACT);
        ParkingSpot parkingSpot6= new ParkingSpot(202,2, SpotType.REGULAR);
        ParkingSpot parkingSpot7= new ParkingSpot(203,2, SpotType.REGULAR);
        ParkingSpot parkingSpot8= new ParkingSpot(204,2, SpotType.LARGE);
        ParkingSpot parkingSpot9= new ParkingSpot(301,3, SpotType.COMPACT);
        ParkingSpot parkingSpot10= new ParkingSpot(302,3, SpotType.REGULAR);
        ParkingSpot parkingSpot11= new ParkingSpot(303,3, SpotType.LARGE);
        ParkingSpot parkingSpot12= new ParkingSpot(304,3, SpotType.LARGE);

        floor1.addParkingSpot(parkingSpot1);
        floor1.addParkingSpot(parkingSpot2);
        floor1.addParkingSpot(parkingSpot3);
        floor1.addParkingSpot(parkingSpot4);
        floor2.addParkingSpot(parkingSpot5);
        floor2.addParkingSpot(parkingSpot6);
        floor2.addParkingSpot(parkingSpot7);
        floor2.addParkingSpot(parkingSpot8);
        floor3.addParkingSpot(parkingSpot9);
        floor3.addParkingSpot(parkingSpot10);
        floor3.addParkingSpot(parkingSpot11);
        floor3.addParkingSpot(parkingSpot12);

    }

    public List<ParkingSpot> getAvailableParkingSpots(SpotType spotType){

        List<ParkingSpot> availableParkingSpots= new ArrayList<>();
        for(Floor floor: floors.values()){
            availableParkingSpots.addAll(floor.getAvailableParkingSpots(spotType));
        }

        return  availableParkingSpots;
    }

    public Ticket getTicket(String ticketId){
        return tickets.getOrDefault(ticketId,null);
    }

}
