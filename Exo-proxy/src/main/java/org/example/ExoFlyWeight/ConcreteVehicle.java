package org.example.ExoFlyWeight;

public class ConcreteVehicle implements Vehicle{
    private String model;
    private String brand;
    private String color;

    public ConcreteVehicle(String model, String brand, String color) {
        this.model = model;
        this.brand = brand;
        this.color = color;
    }

    @Override
    public void showDetails() {
        System.out.println("Vehicle details: Model - " + model + ", Brand - " + brand + ", Color - " + color);
    }
}
