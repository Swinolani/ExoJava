package org.example.DAO;

import org.example.Entity.Categorie;
import org.example.util.InfosConnexion;

import java.sql.*;

public class CategorieDAO {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement stm;
    private static ResultSet res;

    public static void ajouter(Categorie categorie) {
        try {
            connection = DriverManager.getConnection(InfosConnexion.url, InfosConnexion.user, InfosConnexion.mdp);
            preparedStatement = connection.prepareStatement("INSERT INTO categorie (catNom) VALUES (?)");

            if (connection != null) {
                preparedStatement.setString(1, categorie.getCatNom());
                preparedStatement.executeUpdate();
                System.out.println("La Catégorie a été ajoutée avec succès ! ");
            } else {
                System.out.println("Échec de la connexion");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Categorie getCategorieById(Integer id) {
        Categorie targetCategorie = null;
        try {
            connection = DriverManager.getConnection(InfosConnexion.url, InfosConnexion.user, InfosConnexion.mdp);
            preparedStatement = connection.prepareStatement("SELECT * FROM categorie WHERE catId=?");
            preparedStatement.setInt(1, id);
            res = preparedStatement.executeQuery();
            if (res.next()) {
                targetCategorie = Categorie.builder().catId(res.getInt("catId")).catNom(res.getString("catNom")).build();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (res != null) {
                    res.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return targetCategorie;
    }

    public static boolean findByCategorie(String categorie) {
        boolean isCategorie = false;
        try {
            connection = DriverManager.getConnection(InfosConnexion.url, InfosConnexion.user, InfosConnexion.mdp);
            preparedStatement = connection.prepareStatement("SELECT * FROM categorie WHERE catNom=?");
            preparedStatement.setString(1, categorie);
            res = preparedStatement.executeQuery();
            isCategorie = res.first();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (res != null) {
                    res.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return isCategorie;
    }
}
