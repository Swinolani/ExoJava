package com.Swino.TrainingJava;

public class Lot {
    private ArticleUnitaire articleUnitaire;
    private int quantite;
    private double pourcentRemise;

    public Lot(ArticleUnitaire articleUnitaire, int quantite, double pourcentRemise) {
        this.articleUnitaire = articleUnitaire;
        this.quantite = quantite;
        this.pourcentRemise = pourcentRemise;
    }

    public ArticleUnitaire getArticleUnitaire() {
        return articleUnitaire;
    }

    public void setArticleUnitaire(ArticleUnitaire articleUnitaire) {
        this.articleUnitaire = articleUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPourcentRemise() {
        return pourcentRemise;
    }

    public void setPourcentRemise(double pourcentRemise) {
        this.pourcentRemise = pourcentRemise;
    }
}
