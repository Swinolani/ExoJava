package org.example.exoHibernate.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity
@Table
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proId;
    private String proMarque,proReference;
    private LocalDate proDate;
    private Double proPrix;
    private int  proStock;
    @OneToMany(mappedBy = "imaProduit")
    private List<Image> proListImage;
    @OneToMany(mappedBy = "comProduit")
    private List<Commentaire> proListCommentaire;
}
