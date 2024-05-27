package org.example.ExoFlyWeight;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public Vehicle getVehicle(String key, String model, String brand, String color) {
        if (!vehicles.containsKey(key)) {
            vehicles.put(key, new ConcreteVehicle(model, brand, color));
        }
        return vehicles.get(key);
    }
}
