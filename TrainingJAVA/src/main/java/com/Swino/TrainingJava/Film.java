package com.Swino.TrainingJava;

import java.time.LocalDate;
import java.util.Date;

public class Film {
    //Attribut
    private String titre;
    private String realisateur;
    private LocalDate anneeSortie;
    private String genre;

    //Constructor
    public Film(String titre, String realisateur, LocalDate anneeSortie, String genre) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.anneeSortie = anneeSortie;
        this.genre = genre;
    }
    //Getter et Setter

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public LocalDate getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(LocalDate anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", anneeSortie=" + anneeSortie +
                ", genre='" + genre + '\'' +
                '}';
    }
}
