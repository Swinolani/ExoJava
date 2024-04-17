package com.Swino.TrainingJava;

import java.time.LocalDateTime;
import java.util.List;

public class Facture {
    private String numFacture;
    private Client client;
    private LocalDateTime date;

    private List<Ligne> listeLigne;

    public Facture(String numFacture, Client client, LocalDateTime date, List<Ligne> listeLigne) {
        this.numFacture = numFacture;
        this.client = client;
        this.date = date;
        this.listeLigne = listeLigne;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Ligne> getListeLigne() {
        return listeLigne;
    }
    //Méthodes utiles
    public void setListeLigne(List<Ligne> listeLigne) {
        this.listeLigne = listeLigne;
    }

    public void ajouterLigne(Ligne ligne){
        listeLigne.add(ligne);
    }
    public double getPrixTotal() {
        double sum=0.0;
        for(Ligne ligne:listeLigne){
            sum+= (int) (((ligne.getLot().getArticleUnitaire().getPrixUnitaire()*ligne.getLot().getQuantite())-(ligne.getLot().getArticleUnitaire().getPrixUnitaire()*ligne.getLot().getQuantite()*ligne.getLot().getPourcentRemise())/100)*ligne.getQuantite());
        }
        return sum;
    };
}
