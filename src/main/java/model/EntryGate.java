package model;

import java.util.List;
import java.util.Scanner;

public class EntryGate extends Gate{

    public void run(){
        try{

            Scanner sc=new Scanner(System.in);
            while(true) {

                System.out.println("Enter Vehicle details");
                System.out.println("Enter License Number:");
                String licenseNumber = sc.nextLine();
                System.out.println("Enter your name:");
                String ownerName = sc.nextLine();
                SpotType spotType = null;
                outer:
                while (true) {
                    try {


                        System.out.println("Enter Vehicle Type:\n1. Compact \n2. Regular \n3. Large \n Enter 1 or 2 or 3");
                        int spotTypeInput = Integer.parseInt(sc.next().trim());
                        if (spotTypeInput < 1 || spotTypeInput > 3) {
                            System.out.println("Invalid Input!");
                        } else {

                            switch (spotTypeInput) {
                                case 1:
                                    spotType = SpotType.COMPACT;
                                    break;
                                case 2:
                                    spotType = SpotType.REGULAR;
                                    break;
                                case 3:
                                    spotType = SpotType.LARGE;
                                    break;

                            }
                            break outer;
                        }
                    }catch (Exception e){
                        System.out.println("Invalid Input!");
                    }

                }

                Vehicle vehicle = VehicleFactory.getVehicle(licenseNumber, ownerName, spotType);

                List<ParkingSpot> availableParkingSpots = parkingLotApplication.getAvailableParkingSpots(spotType);
                if(availableParkingSpots.size()>0) {
                    System.out.println("Choose the parking spot");

                    while (true) {

                        for (int i = 0; i < availableParkingSpots.size(); i++) {
                            ParkingSpot parkingSpot = availableParkingSpots.get(i);
                            System.out.println(i + ". " + parkingSpot);
                        }

                        int selectedParkingSpot = sc.nextInt();
                        if (selectedParkingSpot >= 0 && selectedParkingSpot < availableParkingSpots.size()) {
                            Ticket ticket = availableParkingSpots.get(selectedParkingSpot).park();
                            System.out.println(ticket);
                            break;
                        } else {
                            System.out.println("Invalid Input!! \nEnter a number between 0 and " + (availableParkingSpots.size() - 1));
                        }

                    }
                }else{
                    System.out.println("No "+ spotType+" available at the moment!");
                }


                System.out.println("Enter exit to close the application or anything else to book a new parking spot:");
                String exitCommand=sc.next();
                if(exitCommand.equals("exit"))break;

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
