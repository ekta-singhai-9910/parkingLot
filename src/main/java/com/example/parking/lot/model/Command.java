package com.example.parking.lot.model;

import java.util.HashMap;

public enum Command {
    CREATE_PARKING_LOT("create_parking_lot"),
    DISPLAY("display"),
    PARK_VEHICLE("park_vehicle"),
    UNPARK_VEHICLE("unpark_vehicle"),
    EXIT("exit");
    private final String value ;

    static final HashMap<String, Command> enumValueHashMap;
    public static Command enumFromValue(String value){
        if(enumValueHashMap.containsValue(value)){
            return enumValueHashMap.get(value);
        }
        else{
            throw new RuntimeException("Invalid value : " + value +  " provided for Command" );
        }
    }
    static{
       HashMap<String, Command> tempHashMap = new HashMap<>();
       for(Command command: Command.values()){
           tempHashMap.put(command.value, command);
       }

       enumValueHashMap =  tempHashMap;
    }

    Command(String value) {
        this.value = value;
    }

}
