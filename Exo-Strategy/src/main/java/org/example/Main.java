package org.example;

public class Main {
    public static void main(String[] args) {
        NavigationSystem destination= new NavigationSystem("les atlantides");
        destination.startNavigation(new EconomicsStrategy());
        destination.startNavigation(new OffRoadStrategy());
        destination.startNavigation(new RoadStrategy());

    }
}