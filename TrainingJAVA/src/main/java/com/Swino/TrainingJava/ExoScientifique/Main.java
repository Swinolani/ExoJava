package com.Swino.TrainingJava.ExoScientifique;

public class Main {
    public static void main(String[] args) {
        Travailleur moi=new Travailleur("Boulaabi","Mohamed","0505050505","fopfoej@gmail.com","e-mhotep","rue des morts","0505050504");
        Travailleur penet=new Travailleur("Penet","Alexandre","9999999999","fopjjytyej@gmail.com","utopios","avenue de la potence","1231231232");
        Scientifique moi2=new Scientifique(moi,"mathématique","analyse");
        System.out.println(moi2.toString());
    }
}
