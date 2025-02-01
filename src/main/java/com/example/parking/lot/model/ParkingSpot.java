package com.example.parking.lot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class ParkingSpot {
    VehicleType vehicleType;
    int floorId;
    int spotId;
    boolean isFree;
    Vehicle vehicle;

    public ParkingSpot(VehicleType vehicleType, int i, int j, boolean b, Vehicle o) {
        this.vehicleType = vehicleType;
        this.floorId = i ; this.spotId = j ; this.isFree = b ; this.vehicle = o;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

