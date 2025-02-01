package com.example.parking.lot.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public enum DisplayType {
    FREE_SLOTS("free_slots"),
    OCCUPIED_SLOTS("occupied_slots"),
    FREE_COUNT("free_count");

    private final String value ;

    DisplayType(String value) {
        this.value = value;
    }

    public static HashMap<String, DisplayType> enumValueHashMap ;

    static {
        HashMap<String, DisplayType> tempHashMap = new HashMap<>();
        for(DisplayType displayType : DisplayType.values()){
            tempHashMap.put(displayType.value, displayType);
        }
        enumValueHashMap = tempHashMap;
    }

    public DisplayType enumFromValue(String value){
        if(enumValueHashMap.containsValue(value)){
            return enumValueHashMap.get(value);
        }
        else{
            throw new RuntimeException("Invalid value : " + value + " provided for DisplayType Enum");
        }
    }
}
