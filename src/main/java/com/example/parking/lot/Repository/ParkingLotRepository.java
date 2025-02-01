package com.example.parking.lot.Repository;

import com.example.parking.lot.model.ParkingFloor;
import com.example.parking.lot.model.ParkingSpot;
import com.example.parking.lot.model.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class ParkingLotRepository {
    List<ParkingFloor> parkingFloors;
    Scanner scanner = new Scanner(System.in);
    public List<ParkingFloor> initializeParkingFloors(int numberOfFloors, int numberOfSlotsPerFloor){

        parkingFloors = new ArrayList<>(numberOfFloors);

        for(int i = 0 ; i < numberOfFloors; i++){
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            int j = 0 ;
           for(VehicleType vehicleType : VehicleType.values()){
               if( j == numberOfSlotsPerFloor){
                   break ;
               }
               int s = j ;
               System.out.println("Enter number of parking spots for vehicle type : " + vehicleType.name() + " on floor no :  " + (i+1));
               int spots = scanner.nextInt();
               for( ; j < Math.min(numberOfSlotsPerFloor, spots + j ); j++){
                   parkingSpots.add(new ParkingSpot(vehicleType, i, j, true, null));
               }
               System.out.println("Added " + (j - s) + " parking slots of type : " + vehicleType );

           }
           parkingFloors.get(i).setFloorId(i);
           parkingFloors.get(i).setParkingSpots(parkingSpots);
        }
        return parkingFloors;
    }


}
