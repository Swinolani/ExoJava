package com.Swino.TrainingJava;

import java.util.Scanner;

public class Main {
    public static Integer convertirStrInt(String nombreString) throws NumberFormatException{
        return Integer.parseInt(nombreString);
    }
    public static float racineCarre(float nombre) throws ArithmeticException{
        if(nombre<0){
            throw new ArithmeticException("impossible de racine carreter un nombre négatif! (en réalité si mais pour le besoin de l'exo ca sera non :) )");
        }
        return (float) Math.sqrt(nombre);
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
    try{
        //Exo 1 : conversion string en int
        System.out.println("entrer un nombre");
        String nombre=scanner.nextLine();

        System.out.println(convertirStrInt(nombre));

        //Exo 2: racine carré
        System.out.println("entrer un nombre a racine carreter");
        String racineString=scanner.nextLine();
        float nombreRacine=Float.parseFloat(racineString);
        System.out.println(racineCarre(nombreRacine));

        //Exo 3
        
    }catch(NumberFormatException e){
        System.out.println("Le paramètre n'est pas un entier !");
    }catch(ArithmeticException e){
        System.out.println(e.getMessage());
    }

    }
}