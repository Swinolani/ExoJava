package org.example;

public class Batiment {
    private final String batNom,batStyle,batCouleur;

    public Batiment(BatimentBuilder builder) {
        this.batNom = builder.batNom;
        this.batStyle = builder.batStyle;
        this.batCouleur = builder.batCouleur;
    }

    public static class BatimentBuilder{
        private String batNom,batStyle,batCouleur;

        public BatimentBuilder batNom(String batNom){
            this.batNom=batNom;
            return this;
        }
        public BatimentBuilder batStyle(String batStyle){
            this.batStyle=batStyle;
            return this;
        }
        public BatimentBuilder batCouleur(String batCouleur){
            this.batCouleur=batCouleur;
            return this;
        }
        public Batiment build(){return new Batiment(this);}

    }
}
