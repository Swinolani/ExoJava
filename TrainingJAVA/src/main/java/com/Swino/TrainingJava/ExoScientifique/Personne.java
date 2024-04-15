package com.Swino.TrainingJava.ExoScientifique;

public abstract class Personne {
    protected String nom,prenom,numero,mail;

    public Personne(String nom, String prenom, String numero, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numero='" + numero + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
