package com.Swino.TrainingJava;

public class Arbre extends Plante{
    private double circonf;

    public Arbre(String nom, double hauteur, String couleurFeuille, double circonf) {
        super(nom, hauteur, couleurFeuille);
        this.circonf = circonf;
    }

    public double getCirconf() {
        return circonf;
    }

    public void setCirconf(double circonf) {
        this.circonf = circonf;
    }

    @Override
    public String toString() {
        return super.toString()+","+
                "circonf=" + circonf +

                '}';
    }
}
