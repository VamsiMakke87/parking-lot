package model;

import service.ParkingLotApplication;

public abstract class Gate {


    public ParkingLotApplication parkingLotApplication= ParkingLotApplication.getInstance();

    public abstract void run();

}
