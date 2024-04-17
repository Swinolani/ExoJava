package com.Swino.TrainingJava;

public class Ligne {
    private Lot lot;
    private int quantite;

    public Ligne(Lot lot, int quantite) {
        this.lot = lot;
        this.quantite = quantite;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String afficherLigne(){
        return "Quantité : "+quantite+", Réference article : "+lot.getArticleUnitaire().getArtId()+", Nom article : "+lot.getArticleUnitaire().getNom()+", Prix unitaire : "+lot.getArticleUnitaire().getPrixUnitaire()+", Prix total : "+((lot.getArticleUnitaire().getPrixUnitaire()*lot.getQuantite())-(lot.getArticleUnitaire().getPrixUnitaire()*lot.getQuantite()*lot.getPourcentRemise())/100)*quantite;
    }

}
