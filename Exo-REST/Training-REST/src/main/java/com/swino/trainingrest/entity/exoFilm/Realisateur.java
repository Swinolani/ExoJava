package com.swino.trainingrest.entity.exoFilm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Realisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;

    private String nationalite;

    @OneToMany(mappedBy = "realisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Film> films;

}
