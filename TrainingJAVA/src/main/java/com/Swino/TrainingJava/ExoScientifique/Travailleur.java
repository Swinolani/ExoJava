package com.Swino.TrainingJava.ExoScientifique;

public class Travailleur extends Personne{
    protected String nomEntreprise,addrEntreprise,telProfessionel;

    public Travailleur(String nom,String prenom,String numero,String mail,String nomEntreprise, String addrEntreprise, String telProfessionel) {
        super(nom,prenom,numero,mail);
        this.nomEntreprise = nomEntreprise;
        this.addrEntreprise = addrEntreprise;
        this.telProfessionel = telProfessionel;
    }

    @Override
    public String toString() {
        return "Travailleur{" +
                "nomEntreprise='" + nomEntreprise + '\'' +
                ", addrEntreprise='" + addrEntreprise + '\'' +
                ", telProfessionel='" + telProfessionel + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numero='" + numero + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
