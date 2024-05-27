package org.example.Entity;

import lombok.Builder;
import lombok.Data;
import org.example.util.Difficulte;

@Data
@Builder
public class Recette {
    private Integer recId;
    //Entier à 4 chiffre en string (en seconde) pour les 2 derniers
    private String recNom,recTempsPrep,recTempsCuisson;
    private Difficulte recDifficulte;
    private Categorie recCategorie;

}
