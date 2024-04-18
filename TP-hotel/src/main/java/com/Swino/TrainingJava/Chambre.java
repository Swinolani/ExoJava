package com.Swino.TrainingJava;

public class Chambre {
    private static Long chamId=0L;
    private double chamTarif;
    private Integer chamCapacite;
    private Boolean chamEstOccupe;

    public Chambre( double chamTarif, Integer chamCapacite, Boolean chamEstOccupe) {
        Chambre.chamId++;
        this.chamTarif = chamTarif;
        this.chamCapacite = chamCapacite;
        this.chamEstOccupe = chamEstOccupe;
    }

    public Long getChamId() {
        return chamId;
    }



    public double getChamTarif() {
        return chamTarif;
    }

    public void setChamTarif(double chamTarif) {
        this.chamTarif = chamTarif;
    }

    public Integer getChamCapacite() {
        return chamCapacite;
    }

    public void setChamCapacite(Integer chamCapacite) {
        this.chamCapacite = chamCapacite;
    }

    public Boolean getChamEstOccupe() {
        return chamEstOccupe;
    }

    public void setChamEstOccupe(Boolean chamEstOccupe) {
        this.chamEstOccupe = chamEstOccupe;
    }
}
