package org.example.Entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliId;
    private String nom,prenom,adresse,numeroTel;
    private int age;

    @OneToMany(mappedBy = "client" )
    private Set<Billet> billet;
}
