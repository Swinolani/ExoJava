package com.Swino.TrainingJava;

public class Ramette extends ArticleUnitaire{
    private double grammage;

    public Ramette(String artId, String nom, double prixUnitaire, double grammage) {
        super(artId, nom, prixUnitaire);
        this.grammage = grammage;
    }

    public double getGrammage() {
        return grammage;
    }

    public void setGrammage(double grammage) {
        this.grammage = grammage;
    }
}
