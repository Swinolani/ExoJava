package com.Swino.TrainingJava;

import java.util.List;

public class Hotel {
    private static Long hotId= 0L;
    private String hotNom;

    private Chambre[] hotListChambre;

    public Hotel(String hotNom, Chambre[] hotListChambre) {
        Hotel.hotId++;
        this.hotNom = hotNom;
        this.hotListChambre = hotListChambre;
    }

    public Long getHotId() {
        return hotId;
    }



    public String getHotNom() {
        return hotNom;
    }

    public void setHotNom(String hotNom) {
        this.hotNom = hotNom;
    }

    public Chambre[] getHotListChambre() {
        return hotListChambre;
    }

    public void setHotListChambre(Chambre[] hotListChambre) {
        this.hotListChambre = hotListChambre;
    }
}
