package org.example.Entities;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@Entity
@Table
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eveId;
    private String nom;
    private Lieu lieu;
    private int heure=LocalDateTime.now().getHour();

    @OneToMany(mappedBy = "evenement")
    private Set<Billet> listBillet;
    public static void main(String[] args) {

    }
}
