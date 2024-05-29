package org.example.exoHibernate.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comId;
    @Length(max = 200)
    private String comContenu;
    private LocalDate comDate;
    @Min(value = 0)
    @Max(value = 5)
    private int comNote;
    @ManyToOne
    @JoinColumn(name = "proId")
    @NotBlank
    private Produit comProduit;

}
