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


            while(true){
                try{
                    Gate gate=null;
                    System.out.println("Enter 1 for entry and 2 for exit");
                    int entryOrExit= Integer.parseInt(sc.next().trim());
                    switch (entryOrExit){
                        case 1: gate= new EntryGate();break;
                        case 2: gate= new ExitGate();break;
                        default:
                            System.out.println("Invalid Input!!");
                    }
                    gate.run();
                    System.out.println("Enter exit to close the application or anything else to book a new parking spot:");
                    String exitCommand=sc.next();
                    if(exitCommand.equals("exit"))break;
                }catch(Exception e){
                    System.out.println("Invalid Input!!");
                }
            }




        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

}
