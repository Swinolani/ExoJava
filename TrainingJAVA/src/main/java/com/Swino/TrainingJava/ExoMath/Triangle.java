package com.Swino.TrainingJava.ExoMath;

public class Triangle extends Figure{
    private final double base,hauteur;


    public Triangle(double base, double hauteur) {
        this.base = base;
        this.hauteur = hauteur;
    }

    @Override
    public void deplacement(double x, double y) {
        System.out.println("Deplacement du Triangle par ("+x+", "+y+")\n");
        super.coord.posX+=x;
        super.coord.posY+=y;
    }
    public void infosTriangle(){
        System.out.println("Coordonnées du triangle ABC (Base= "+base+", Hauteur= "+hauteur+") :\n A= "+super.coord.posX+", "+super.coord.posY+"\n B= "+(super.coord.posX+base)+", "+(super.coord.posY)+"\n " +
                "C= "+((super.coord.posX+super.coord.posX+base)/2)+", "+(super.coord.posY+hauteur));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", hauteur=" + hauteur +
                '}';
    }
}
