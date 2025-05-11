package model;

import service.ParkingLotApplication;

import java.util.Scanner;

public abstract class Gate {


    protected ParkingLotApplication parkingLotApplication= ParkingLotApplication.getInstance();

    protected Scanner sc=new Scanner(System.in);

    public abstract void run();

}
