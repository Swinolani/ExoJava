package com.Swino.TrainingJava;

public class Chaise {
    //Attributs

    private Integer nbrPieds;
    private String materiaux;
    private String couleur;
    private double prix;

    //Constructeurs

    public Chaise(Integer nbrPieds, String materiaux, String couleur, double prix) {
        this.nbrPieds = nbrPieds;
        this.materiaux = materiaux;
        this.couleur = couleur;
        this.prix = prix;
    }

    public Chaise(){
        this(4,"chène","bleu",14.4);

    }

    //Getters et setters
    public Integer getNbrPieds() {
        return nbrPieds;
    }

    public void setNbrPieds(Integer nbrPieds) {
        this.nbrPieds = nbrPieds;
    }

    public String getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(String materiaux) {
        this.materiaux = materiaux;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Chaise{" +
                "nbrPieds=" + nbrPieds +
                ", materiaux='" + materiaux + '\'' +
                ", couleur='" + couleur + '\'' +
                ", prix=" + prix +
                '}';
    }
}
