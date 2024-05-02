package org.example;

public class Personnage {
    private CategoriePerso perCategorie;
    private double perArmure;
    private double perAD;
    private double perAP;

    public Personnage(PersonnageBuilder builder) {
        this.perCategorie = builder.perCategorie;
        this.perArmure = builder.perArmure;
        this.perAD = builder.perAD;
        this.perAP = builder.perAP;
    }

    public static class PersonnageBuilder{
        private CategoriePerso perCategorie;
        private double perArmure;
        private double perAD;
        private double perAP;

        public PersonnageBuilder perCategorie(CategoriePerso perCategorie){
            this.perCategorie=perCategorie;
            return this;
        }
        public PersonnageBuilder perArmure(double perArmure){
            this.perArmure=perArmure;
            return this;
        }
        public PersonnageBuilder perAD(double perAD){
            this.perAD=perAD;
            return this;
        }
        public PersonnageBuilder perAP(double perAP){
            this.perAP=perAP;
            return this;
        }
        public Personnage build(){return new Personnage(this);}
    }
}
