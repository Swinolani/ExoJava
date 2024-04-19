package com.Swino.TrainingJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Fonction pour convertir en entier
    public static Integer convertirStrInt(String nombreString) throws NumberFormatException{
        return Integer.parseInt(nombreString);
    }
    //Fonction qui calcule la racine carré d'un nombre
    public static float racineCarre(float nombre) throws ArithmeticException{
        if(nombre<0){
            throw new ArithmeticException("impossible de racine carreter un nombre négatif!" +
                    " (en réalité si mais pour le besoin de l'exo ca sera non :) )");
        }
        return (float) Math.sqrt(nombre);
    }
    public static void main(String[] args) {
        //Tous les exos se feront testé d'un coup
        Scanner scanner= new Scanner(System.in);
    try{
        //Exo 1 : conversion string en int
        System.out.println("entrer un nombre");
        String nombre=scanner.nextLine();

        System.out.println(convertirStrInt(nombre));

        //Exo 2: racine carré
        System.out.println("entrer un nombre a racine carreter");
        String racineString=scanner.nextLine();
        //Ici je recupere quand même l'exception de l'exo 1 avec cette manip si jamais elle est provoqué
        float nombreRacine=Float.parseFloat(racineString);
        System.out.println(racineCarre(nombreRacine));

        //Exo 3 : Tableau sans 6e element
        int[] tabEntier={2,3,5,7,11};
        System.out.println("j'ai crée un tableau d'entier de taille 5, tu veux acceder à quelle cellule?");
        String indexTab=scanner.nextLine();
        //J'ai crée une methode qui convertie en int, autant l'utiliser
        int indexTabInt=convertirStrInt(indexTab);
        System.out.println(tabEntier[indexTabInt]);

        //Exo 4 List étudiant
        //Création d'une liste qui sera remplis plus tard
        List<Student> listStudent=new ArrayList<>();
        System.out.println("Choisissez une option : \n " +
                "1-Ajouter un étudiant\n " +
                "2-Voir la liste des étudiant \n " +
                "3-Quitter le programme");
        String choix=scanner.nextLine();
        //On force l'utilisateur à entrer 1,2 ou 3
        while(!(choix.equals("1")||choix.equals("2")||choix.equals("3"))){
            System.out.println("Entrez le nombre correspondant à l'une de ces options : \n" +
                    "1-Ajouter un étudiant\n" +
                    "2-Voir la liste des étudiant\n" +
                    "3-Quitter le programme");
            choix=scanner.nextLine();
        }
        //Tant que l'utilisateur ne souhaite pas quitter le programme
        while(!choix.equals("3")){

            switch (choix){
                case "1":
                    System.out.println("entrez un nom");
                    String nom=scanner.nextLine();
                    System.out.println("Entrez un age");
                    String age=scanner.nextLine();
                    int ageInt=convertirStrInt(age);
                    //L'instanciation est surrounded car dans la classe, on controle l'exeption via le constructeur
                    try{
                        Student student=new Student(nom,ageInt);
                        listStudent.add(student);

                    }catch(InvalidAgeException e){
                        System.out.println(e.getMessage());

                    }
                    break;
                case "2":
                    System.out.println("Voici la liste complète des étudiants : ");
                    listStudent.forEach(student-> System.out.println("Nom : "+student.getStuName()+"/ Age : "+student.getStuAge()));
                    System.out.print("\n");
                    break;

            }
            System.out.println("Choisissez une option : \n " +
                    "1-Ajouter un étudiant\n " +
                    "2-Voir la liste des étudiant \n " +
                    "3-Quitter le programme");
            choix=scanner.nextLine();

        }

        
    }catch(NumberFormatException e){
        System.out.println("Le paramètre n'est pas un entier !");
    }catch(ArithmeticException e){
        System.out.println(e.getMessage());
    }catch (ArrayIndexOutOfBoundsException e){
        System.out.println("l'index entrée est en dehors de la taille du tableau");
    }

    }
}