package org.example.Entities;

import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@Entity
@Table
public class Lieu extends Adresse{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lieId;
    private int capacite;
}
