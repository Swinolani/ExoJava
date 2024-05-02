package org.example;

public class OffRoadStrategy extends StrategiesNavigation {
    @Override
    public void navigate(String destination) {
        System.out.println("je navigue hors route vers "+destination);
    }
}
