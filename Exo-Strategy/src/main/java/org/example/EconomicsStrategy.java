package org.example;

import java.sql.SQLOutput;

public class EconomicsStrategy extends StrategiesNavigation {
    @Override
    public void navigate(String destination) {
        System.out.println("je navigue économiquement vers "+destination);
    }
}
