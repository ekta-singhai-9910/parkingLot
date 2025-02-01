package com.example.parking.lot.model;

import lombok.Data;


public class Vehicle {
    private VehicleType vehicleType;
    private ParkingSpot parkingSpot;
    private String vehicleId;
    private String ticketNo;

    public Vehicle(VehicleType vehicleType, ParkingSpot spot, String vehicleId, String ticketNo){
        this.parkingSpot = spot;
        this.ticketNo = ticketNo;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public String getVehicleId(){
        return vehicleId;
    }
    public String getTicketNo(){
        return ticketNo;
    }
    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    }

    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }
    public void setVehicleId(String vehicleId){
        this.vehicleId = vehicleId;
    }
    public void setTicketNo(String ticketNo){
        this.ticketNo = ticketNo;
    }
    public void setParkingSpot(ParkingSpot spot){
        this.parkingSpot = spot;
    }
}
