package model;

public class VehicleFactory {

    public static Vehicle getVehicle(String licenseNumber, String ownerName, SpotType spotType){

        switch (spotType){
            case COMPACT : return new CompactVehicle(licenseNumber,ownerName);
            case REGULAR: return new RegularVehicle(licenseNumber,ownerName);
            case LARGE: return new LargeVehicle(licenseNumber,ownerName);
        }

        return  null;

    }

}
