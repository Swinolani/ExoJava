package com.Swino.TrainingJava;

public class Stylo extends ArticleUnitaire{
    private String couleur;

    public Stylo(String artId, String nom, double prixUnitaire, String couleur) {
        super(artId, nom, prixUnitaire);
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
