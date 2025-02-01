package com.example.parking.lot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


public class ParkingLot {

    int numberOfFloors ;
    int numberOfSpotsPerFloor;
    int parkingLotId;
    List<ParkingFloor>parkingFloors = new ArrayList<>(numberOfFloors);

    public ParkingLot(int numberOfFloors, int numberOfSpotsPerFloor, int parkingLotId){
        this.numberOfFloors = numberOfFloors;
        this.parkingFloors = new ArrayList<>(numberOfFloors);
        this.numberOfSpotsPerFloor = numberOfSpotsPerFloor;
        this.parkingLotId = parkingLotId;
    }

    public int getParkingLotId(){
        return parkingLotId;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getNumberOfSpotsPerFloor() {
        return numberOfSpotsPerFloor;
    }

    public void setNumberOfSpotsPerFloor(int numberOfSpotsPerFloor) {
        this.numberOfSpotsPerFloor = numberOfSpotsPerFloor;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
