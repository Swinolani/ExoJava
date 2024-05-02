package org.example.ExoStrategie2;

public class TVAStrategy implements TaxStrategy{
    @Override
    public void calculateTax(double tax) {
        System.out.println("Selon la tva, vos taxes s'elevant à "+tax+" vous aurez à débourser (formule a caler ici)");
    }
}
