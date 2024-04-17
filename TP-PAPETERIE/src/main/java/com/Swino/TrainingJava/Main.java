package com.Swino.TrainingJava;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Creation de stylos fictifs
        ArticleUnitaire stylo1=new Stylo("reijgopjoepg54","Bic",3.0,"bleu");
        ArticleUnitaire stylo2=new Stylo("ojrijggopjjo555","Duda",1.5,"vert");
        ArticleUnitaire stylo3=new Stylo("56rh46nrtt645t5","gleu",9.70,"noir");

        //Création de ramettes fictifs
        ArticleUnitaire ramette1=new Ramette("efgegrergzgrz45","fleu",20.5,500);
        ArticleUnitaire ramette2=new Ramette("trhhtththrhdtt4","loe",15.80,1000);

        //Création du tableau qui contiendra mes article unitaires
        Map<String,ArticleUnitaire> listArticle=new HashMap<>();
        //On ajoute tous les article que l'on a crée
        listArticle.put(stylo1.getArtId(),stylo1);
        listArticle.put(stylo2.getArtId(),stylo2);
        listArticle.put(stylo3.getArtId(),stylo3);
        listArticle.put(ramette1.getArtId(),ramette1);
        listArticle.put(ramette2.getArtId(),ramette2);

        //Création de clients fictifs
        Client moh=new Client("Boulaabi", "Mohamed");
        Client penet=new Client("Penet","Alexandre");

        //Création de lots randoms
        Lot lot1=new Lot(listArticle.get("reijgopjoepg54"),30,20); // Juste pour que ma collection Map serve à quelque chose
        Lot lot2=new Lot(ramette2,200,0);
        Lot lot3=new Lot(stylo2,10,10);
        Lot lot4=new Lot(ramette1,70,50);
        Lot lot5=new Lot(stylo3,40,30);

        //Creation d'un tableau de ligne
        List<Ligne> listLigne=new ArrayList<>();
        listLigne.add(new Ligne(lot2,4));
        listLigne.add(new Ligne(lot3,3));

        //Création de Facture (pour me faciliter la creation des tableaux)
        Facture facturePenet=new Facture("21",penet, LocalDateTime.now(),listLigne);

        //Le prix que penet me doit (jai fait une erreur dans ma formule ^^)
        System.out.println(facturePenet.getPrixTotal());

    }
}