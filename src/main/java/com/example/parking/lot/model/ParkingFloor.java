package com.example.parking.lot.model;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;


public class ParkingFloor {
    int floorId;
    List<ParkingSpot> parkingSpots ;

    ParkingFloor(int floorId, List<ParkingSpot> spots){
        this.floorId = floorId;
        this.parkingSpots = spots;
    }

    public  int getFloorId(){
        return floorId;
    }

    public List<ParkingSpot> getParkingSpots(){
        return parkingSpots;
    }

    public void setFloorId(int floorId){
        this.floorId = floorId;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots){
        this.parkingSpots = parkingSpots;
    }
}
