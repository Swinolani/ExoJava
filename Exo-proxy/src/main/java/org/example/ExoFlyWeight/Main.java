package org.example.ExoFlyWeight;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();


        Vehicle car1 = factory.getVehicle("car", "SUV", "Toyota", "Red");
        Vehicle car2 = factory.getVehicle("car", "SUV", "Toyota", "Red");
        Vehicle bike1 = factory.getVehicle("bike", "Mountain", "Giant", "Black");


        car1.showDetails();
        car2.showDetails();
        bike1.showDetails();
    }
}
