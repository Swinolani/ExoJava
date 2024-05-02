package org.example.ExoStrategie2;

public class ImpotForfaitaireStrategy implements TaxStrategy{
    @Override
    public void calculateTax(double tax) {
        System.out.println("Selon l'impot forfaite, vos taxes s'elevant à "+tax+" vous aurez à débourser (formule a caler ici)");
    }
}
