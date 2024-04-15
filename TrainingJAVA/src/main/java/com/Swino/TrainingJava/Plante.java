package com.Swino.TrainingJava;

public class Plante {
    protected String nom;
    protected double hauteur;
    protected String couleurFeuille;

    //Constructeur
    public Plante(String nom, double hauteur, String couleurFeuille) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleurFeuille = couleurFeuille;
    }
    public  Plante(){};
    //Getter et Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public String getCouleurFeuille() {
        return couleurFeuille;
    }

    public void setCouleurFeuille(String couleurFeuille) {
        this.couleurFeuille = couleurFeuille;
    }

    @Override
    public String toString() {
        return  super.getClass().getSimpleName()+
                "{nom='" + nom + '\'' +
                ", hauteur=" + hauteur +
                ", couleurFeuille='" + couleurFeuille + '\'';
    }
}
