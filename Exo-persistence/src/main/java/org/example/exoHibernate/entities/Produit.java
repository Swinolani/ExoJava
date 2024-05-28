package org.example.exoHibernate.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
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
}
