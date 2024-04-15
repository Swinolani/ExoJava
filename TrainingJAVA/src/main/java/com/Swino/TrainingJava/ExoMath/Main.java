package com.Swino.TrainingJava.ExoMath;

public class Main {
    public static void main(String[] args) {
        // Manipulation du carré
        Carre carre1= new Carre(2.0);
        carre1.infosCarre();
        carre1.deplacement(3,3);
        carre1.infosCarre();
        carre1.deplacement(-1,0);
        carre1.infosCarre();

        // Manipulation du rectangle
        Rectangle rectangle1=new Rectangle(5,2);
        rectangle1.infosRectangle();
        rectangle1.deplacement(3,-1);
        rectangle1.infosRectangle();

        // Manipulation du triangle
        Triangle triangle1=new Triangle(4,2);
        triangle1.infosTriangle();
        triangle1.deplacement(1,3);
        triangle1.infosTriangle();
    }
}
