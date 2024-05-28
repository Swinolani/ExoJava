package org.example.exoBiletterie.Entities;

import lombok.Builder;
import lombok.Data;
import org.example.exoBiletterie.Util.TypeDePlace;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bilId;

    private int numPlace;
    @ManyToOne
    @JoinColumn(name="cliId")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "eveId")
    private Evenement evenement;
    private TypeDePlace typeDePlace;
}
