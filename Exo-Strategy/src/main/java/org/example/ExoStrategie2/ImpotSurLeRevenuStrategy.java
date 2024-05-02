package org.example.ExoStrategie2;

public class ImpotSurLeRevenuStrategy implements  TaxStrategy{
    @Override
    public void calculateTax(double tax) {
        System.out.println("Selon l'impot sur le revenu, vos taxes s'elevant à "+tax+" vous aurez à débourser (formule a caler ici)");
    }
}
