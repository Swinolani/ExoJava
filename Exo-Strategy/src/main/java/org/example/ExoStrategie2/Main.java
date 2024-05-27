package org.example.ExoStrategie2;

public class Main {
    public static void main(String[] args) {
        CalculusSystem calculTaxe=new CalculusSystem(200.5);
        calculTaxe.conversionTax(new ImpotSurLeRevenuStrategy());
        calculTaxe.conversionTax(new ImpotForfaitaireStrategy());
        calculTaxe.conversionTax(new TVAStrategy());
    }


}
