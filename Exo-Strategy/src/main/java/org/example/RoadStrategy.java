package org.example;

public class RoadStrategy extends StrategiesNavigation {
    @Override
    public void navigate(String destination) {
        System.out.println("je navigue sur la route vers "+destination);
    }
}
