package com.Swino.TrainingJava.ExoScientifique;

public class Scientifique {
    private final Travailleur travailleur;
    private final String discipline,type;

    public Scientifique(Travailleur travailleur,String discipline, String type) {
        this.travailleur = travailleur;
        this.discipline = discipline;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Scientifique{" +
                "travailleur=" + travailleur +
                ", discipline='" + discipline + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
