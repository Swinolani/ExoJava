package com.Swino.TrainingJava.ExoMath;

public class Rectangle extends Figure {
    private final double longueur,largeur;

    public Rectangle(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public void deplacement(double x, double y) {
        System.out.println("Deplacement du Rectangle par ("+x+", "+y+")\n");
        super.coord.posX+=x;
        super.coord.posY+=y;
    }
    public void infosRectangle(){
        System.out.println("Coordonnées du rectangle ABCD (Longueur= "+longueur+", Largeur= "+largeur+") :\n A= "+super.coord.posX+", "+super.coord.posY+"\n B= "+(super.coord.posX+longueur)+", "+(super.coord.posY)+"\n " +
                "C= "+(super.coord.posX+longueur)+", "+(super.coord.posY+largeur)+"\n D= "+super.coord.posX+", "+(super.coord.posY+largeur)+"\n");
    }
    @Override
    public String toString() {
        return "Rectangle{" +
                "longueur=" + longueur +
                ", largeur=" + largeur +
                '}';
    }
}
