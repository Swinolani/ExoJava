package org.example.DAO;

import org.example.Entity.Categorie;
import org.example.Entity.Ingredient;
import org.example.util.InfosConnexion;

import java.sql.*;

public class IngredientDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement stm;
    private static ResultSet res;


    public static void ajouter(Ingredient ingredient) throws SQLException {
        try{
            connection = DriverManager.getConnection(InfosConnexion.url, InfosConnexion.user, InfosConnexion.mdp);
            preparedStatement=connection.prepareStatement("INSERT INTO ingredient (ingNom) VALUE (?)");

            if (connection != null) {
                preparedStatement.setString(1, ingredient.getIngNom());
                preparedStatement.executeUpdate();
                System.out.println("L'ingrédient a été ajouté avec succés ! ");
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
    public static Ingredient getIngredientById(Integer id) throws SQLException {
        Ingredient targetIngredient = null;
        try{
            connection = DriverManager.getConnection(InfosConnexion.url, InfosConnexion.user, InfosConnexion.mdp);
            stm=connection.createStatement();
            res=stm.executeQuery("SELECT * FROM ingredient where ingId="+ id);
            targetIngredient= Ingredient.builder().ingId(res.getInt("ingId")).ingNom(res.getString("ingNom")).build();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            assert connection != null;
            connection.close();
            stm.close();
            res.close();
        }
        return targetIngredient;
    }
}
