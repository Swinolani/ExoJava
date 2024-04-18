package com.Swino.TrainingJava;

public class Main {
    public static void main(String[] args) {
        // Génération d'un hôtel avec un nombre de chambres compris entre 20 et 40
        Chambre[] chambres = new Chambre[(int)Math.floor(Math.random() * 21 + 20)];
        Hotel hotel = new Hotel("PapHotel", chambres);

        for (int i = 0; i < chambres.length; i++) {
            // Chaque chambre a un tarif random et une capacité random
            chambres[i] = new Chambre(((Math.floor(Math.random()*61*100))/100+40), (int) Math.floor(Math.random()*4+1),
                    false);
        }



    }
}