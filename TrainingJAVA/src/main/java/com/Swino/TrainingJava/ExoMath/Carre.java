package com.Swino.TrainingJava.ExoMath;

public class Carre extends Figure{
    private final double cote;



    public Carre(double cote) {
        this.cote = cote;
    }
    public void infosCarre(){
        System.out.println("Coordonnées du carré ABCD (cote= "+cote+") :\n A= "+super.coord.posX+", "+super.coord.posY+"\n B= "+(super.coord.posX+cote)+", "+(super.coord.posY)+"\n " +
                "C= "+(super.coord.posX+cote)+", "+(super.coord.posY+cote)+"\n D= "+super.coord.posX+", "+(super.coord.posY+cote)+"\n");

    }
    @Override
    public void deplacement(double x, double y) {
        System.out.println("Deplacement du Carre par ("+x+", "+y+")\n");
        super.coord.posX+=x;
        super.coord.posY+=y;
    }

    @Override
    public String toString() {
        return "Carre{" +
                "cote=" + cote +
                '}';
    }
}
