package org.example;

import org.example.DAO.CategorieDAO;
import org.example.DAO.RecetteDAO;
import org.example.Entity.Categorie;
import org.example.Entity.Recette;
import org.example.util.Difficulte;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Recette recetteRandom= Recette.builder().recNom("roti de clope").recTempsCuisson("123").recTempsPrep("12").recDifficulte(Difficulte.MOYEN).recCategorie(Categorie.builder().catNom("invention").build()).build();

       if(CategorieDAO.findByCategorie(recetteRandom.getRecCategorie().getCatNom())){
           RecetteDAO.ajouter(recetteRandom);
       }else{

           CategorieDAO.ajouter(Categorie.builder().catNom(recetteRandom.getRecCategorie().getCatNom()).build());
           //RecetteDAO.ajouter(recetteRandom);
       }

    }
}
