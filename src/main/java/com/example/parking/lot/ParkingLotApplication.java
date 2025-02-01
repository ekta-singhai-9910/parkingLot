package com.example.parking.lot;

import com.example.parking.lot.model.Command;
import com.example.parking.lot.model.ParkingLot;
import com.example.parking.lot.model.Vehicle;
import com.example.parking.lot.model.VehicleType;
import com.example.parking.lot.service.ParkingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

public class ParkingLotApplication {

	public static void main(String[] args) {
		ParkingService parkingService = new ParkingService();

		while(true){
			Scanner scanner = new Scanner(System.in);
			Command command = Command.valueOf(scanner.next());

			switch(command){
                case CREATE_PARKING_LOT : parkingService.createParkingLot(new ParkingLot(
                            scanner.nextInt(), scanner.nextInt(), scanner.nextInt()
                            )
                    ); break ;

                case PARK_VEHICLE :
                    parkingService.parkVehicle(VehicleType.valueOf(scanner.next()), scanner.next());
                    break ;


                case UNPARK_VEHICLE :
                    parkingService.unParkVehicle(scanner.next());
                    break ;


                case EXIT : return;


            }
		}
	}

}
