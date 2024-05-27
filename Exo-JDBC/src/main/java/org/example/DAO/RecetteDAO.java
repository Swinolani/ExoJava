package org.example.DAO;

import org.example.Entity.Recette;
import org.example.util.Difficulte;
import org.example.util.InfosConnexion;


import java.sql.*;

public class RecetteDAO {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement stm;
    private static ResultSet res;
    public static void ajouter(Recette recette) throws SQLException {
        try{
            connection = DriverManager.getConnection(InfosConnexion.url, InfosConnexion.user, InfosConnexion.mdp);
            preparedStatement=connection.prepareStatement("INSERT INTO Recette (recNom,recTempsPrep,recTempsCuisson,repDifficulte,categorie) VALUES (?,?, ?,?,?)");

            if (connection != null) {
                preparedStatement.setString(1, recette.getRecNom() );
                preparedStatement.setString(2, recette.getRecTempsPrep());
                preparedStatement.setString(3, recette.getRecTempsCuisson());
                preparedStatement.setString(4, String.valueOf(recette.getRecDifficulte()));
                preparedStatement.setInt(5, recette.getRecCategorie().getCatId());
                preparedStatement.executeUpdate();
                System.out.println("La recette a été ajouté avec succés ! ");
            } else {
                System.out.println("Échec de la connexion");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            assert connection != null;
            connection.close();
            preparedStatement.close();
        }

    }
    public static void modifierById(Integer id,Recette recette) throws SQLException {
        try {
            connection = DriverManager.getConnection(InfosConnexion.url, InfosConnexion.user, InfosConnexion.mdp);
            preparedStatement=connection.prepareStatement("UPDATE recette SET recNom = ?, recTempsPrep = ?, recTempsCuisson = ?,recDifficulte=?,catId=?\n" +
                    "WHERE condition");

            if (connection != null) {
                preparedStatement.setString(1, recette.getRecNom() );
                preparedStatement.setString(2, recette.getRecTempsPrep());
                preparedStatement.setString(3, recette.getRecTempsCuisson());
                preparedStatement.setString(4, String.valueOf(recette.getRecDifficulte()));
                preparedStatement.setInt(5, recette.getRecCategorie().getCatId());
                preparedStatement.executeUpdate();
                System.out.println("La recette a été modifié avec succés ! ");
            } else {
                System.out.println("Échec de la connexion");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            assert connection != null;
            connection.close();
            preparedStatement.close();
        }

    }
    // Cette méthode est incomplète, faut supprimer les étapes lié à la recette pour que ca marche
    public static void supprimerById(Integer id) throws SQLException {
        try{
            connection = DriverManager.getConnection(InfosConnexion.url, InfosConnexion.user, InfosConnexion.mdp);
            stm=connection.createStatement();
            res=stm.executeQuery("DELETE from recette where recId="+ id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            assert connection != null;
            connection.close();
            stm.close();
            res.close();
        }

    }
    public static Recette getRecetteById(Integer id) throws SQLException {
        Recette targetRecette = null;
        try{
            connection = DriverManager.getConnection(InfosConnexion.url, InfosConnexion.user, InfosConnexion.mdp);
            stm=connection.createStatement();
            res=stm.executeQuery("SELECT * FROM recette where recId="+ id);
            targetRecette=Recette.builder().recId(id).recNom(res.getString("recNom")).recTempsPrep(res.getString("recTempsPrep")).recTempsCuisson(res.getString("recTempsCuisson")).recDifficulte(Difficulte.valueOf(res.getString("recDifficulte"))).recCategorie(CategorieDAO.getCategorieById(res.getInt("catId"))).build();
            

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            assert connection != null;
            connection.close();
            stm.close();
            res.close();
        }
        return targetRecette;
    }
}
