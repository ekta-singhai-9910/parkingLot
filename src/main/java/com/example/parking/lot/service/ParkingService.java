package com.example.parking.lot.service;

import com.example.parking.lot.Repository.ParkingLotRepository;
import com.example.parking.lot.model.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ParkingService {

    HashMap<String, Vehicle> vehicleHashMap;
    ParkingLot parkingLot;
    ParkingLotRepository parkingLotRepository ;


    public void createParkingLot(ParkingLot parkingLot){
        vehicleHashMap = new HashMap<>();
        this.parkingLot = parkingLot;
        this.parkingLotRepository = new ParkingLotRepository();
        this.parkingLot.setParkingFloors(parkingLotRepository.initializeParkingFloors(parkingLot.getNumberOfFloors(), parkingLot.getNumberOfSpotsPerFloor()));
        System.out.println("Created parking lot with lot id" + parkingLot.getParkingLotId() +  " " +  parkingLot.getNumberOfFloors() + " parking floors ");
    }


    public String parkVehicle(VehicleType vehicleType, String vehicleId){
       ParkingSpot parkingSpot = findFirstAvailableParkingSpot(vehicleType);
       if(parkingSpot != null){
           String ticketNo = vehicleId + "~" + (parkingSpot.getSpotId() + 1) + "~" + (parkingSpot.getFloorId() + 1);
           Vehicle vehicle = new Vehicle(vehicleType, parkingSpot, vehicleId, ticketNo);
          parkingSpot.setVehicle(vehicle);
          parkingSpot.setFree(false);
          vehicleHashMap.put(ticketNo, vehicle);
           System.out.println("Parked vehile no " + vehicleId + " at parking spot " +  parkingSpot.getSpotId() + " on floor no " + parkingSpot.getFloorId() + "with ticket " + ticketNo);
          return ticketNo;
       }
       else{
           System.out.println("No parking slot available for vehicle type : " + vehicleType.name());

           return null ;
       }
    }

    public void unParkVehicle(String ticketId){
        if(!vehicleHashMap.containsValue(ticketId)){
            System.out.println(" Invalid ticket no");
            return;
        }
        Vehicle vehicle = vehicleHashMap.get(ticketId);
        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setFree(true);
        parkingSpot.setVehicle(null);
        parkingLot.getParkingFloors().get(parkingSpot.getFloorId()).getParkingSpots().get(parkingSpot.getSpotId()).setFree(true);
        vehicleHashMap.remove(ticketId);

    }

    private ParkingSpot findFirstAvailableParkingSpot(VehicleType vehicleType){
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();

        for(ParkingFloor parkingFloor : parkingFloors){
            List<ParkingSpot> parkingSpots = parkingFloor.getParkingSpots().stream()
                    .filter(parkingSpot -> parkingSpot.getVehicleType() == vehicleType).toList();

            if(!parkingSpots.isEmpty()){
                return parkingSpots.get(0);
            }
        }

        return null ;
    }

}
