package com.Swino.TrainingJava;

public abstract class ArticleUnitaire extends Article {
    private String nom;
    private double prixUnitaire;

    public ArticleUnitaire(String artId, String nom, double prixUnitaire) {
        super(artId);
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
