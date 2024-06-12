package com.swino.exercice4;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Chat {
    private String nom;
    private String race;
    private String repasFavoris;
    private LocalDate dateNaissance;

    // Constructeur
    public Chat(String nom, String race, String repasFavoris, LocalDate dateNaissance) {
        this.nom = nom;
        this.race = race;
        this.repasFavoris = repasFavoris;
        this.dateNaissance = dateNaissance;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRepasFavoris() {
        return repasFavoris;
    }

    public void setRepasFavoris(String repasFavoris) {
        this.repasFavoris = repasFavoris;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
