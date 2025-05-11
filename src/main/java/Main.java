import model.*;
import service.ParkingLotApplication;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to Parking Lot");
            ParkingLotApplication parkingLotApplication = ParkingLotApplication.getInstance();
            parkingLotApplication.initalise();

            Gate gate=null;
            while(true){
                try{
                    System.out.println("Enter 1 for entry and 2 for exit");
                    int entryOrExit= Integer.parseInt(sc.next().trim());
                    switch (entryOrExit){
                        case 1: gate= new EntryGate();break;
                        case 2: gate= new ExitGate();break;
                        default:
                            System.out.println("Invalid Input!!");
                    }
                    break;
                }catch(Exception e){
                    System.out.println("Invalid Input!!");
                }
            }

            gate.run();


        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

}
