package com.Swino.TrainingJava.ExoMath;

public class Point {
    protected double posX=0.0;
    protected double posY=0.0;

    public Point(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public String toString() {
        return "Point{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
