package com.swino.trainingrest.entity.exoFilm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateDeSortie;

    private String description;

    private int duree;

    private String genre;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    @JsonIgnore
    private Realisateur realisateur;
}
