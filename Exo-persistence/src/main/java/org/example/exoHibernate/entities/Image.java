package org.example.exoHibernate.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imaId;
    private String imaUrl;
    @ManyToOne
    @JoinColumn(name = "proId")
    @NotBlank
    private Produit imaProduit;


}
