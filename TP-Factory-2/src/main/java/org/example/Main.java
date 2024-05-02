package org.example;

import org.example.Entity.AbstractProductBuilder;
import org.example.Entity.Bike;
import org.example.Entity.Computer;
import org.example.Entity.Smartphone;
import org.example.Factory.BikeFactory;
import org.example.Factory.ComputerFactory;
import org.example.Factory.SmartphoneFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Dans cette IHM, on se contentera de sysout le produit qui a été build

        //Creation des factories pour la suite
        BikeFactory bikeFactory=new BikeFactory();
        ComputerFactory computerFactory=new ComputerFactory();
        SmartphoneFactory smartphoneFactory=new SmartphoneFactory();

        // On demande au client de choisir son produit
        Scanner scanner= new Scanner(System.in);
        System.out.println("Que voulez vous créer ? Entrez le nombre correspondant à votre choix\n 1 - Ordinateur\n 2 - Smartphone\n 3 - Vélo");
        String productNumber=scanner.nextLine();

        // On force le client à ne choisir que 1, 2 ou 3
        while(!(productNumber.equals("1")||productNumber.equals("2")||productNumber.equals("3"))){
            System.out.println("Entrez le nombre correspondant à votre choix\n 1 - Ordinateur\n 2 - Smartphone\n 3 - Vélo");
            productNumber=scanner.nextLine();
        }
        switch (productNumber){
            case "1":
                System.out.println("Quelle marque de processeur voulez vous ? Intel ou  AMD");
                String processor=scanner.nextLine();
                while(!(processor.equals("Intel")||processor.equals("AMD"))){
                    System.out.println("Entrez la marque de votre choix : Intel ou AMD");
                    processor=scanner.nextLine();
                }
                System.out.println("Quelle type de mémoire voulez vous ? RAM ou SSD");
                String memory=scanner.nextLine();
                while(!(memory.equals("RAM")||memory.equals("SSD"))){
                    System.out.println("Entrez le type de mémoire de votre choix : RAM ou SSD");
                    memory=scanner.nextLine();
                }
                Computer.ComputerBuilder computer=  new Computer.ComputerBuilder().processor(processor).memory(memory);

                System.out.println(computerFactory.createProduct(computer));
                break;
            case "2":
                System.out.println("Quelle marque de processeur voulez vous ? Intel ou AMD");
                String processor2=scanner.nextLine();
                while(!(processor2.equals("1")||processor2.equals("2"))){
                    System.out.println("Entrez la marque de votre choix : Intel ou  AMD");
                    processor2=scanner.nextLine();
                }

                System.out.println("Quelle type de mémoire voulez vous ? RAM ou SSD");
                String memory2=scanner.nextLine();
                while(!(memory2.equals("1")||memory2.equals("2"))){
                    System.out.println("Entrez le type de mémoire de votre choix : RAM ou SSD");
                    memory2=scanner.nextLine();
                }
                Smartphone.SmartphoneBuilder smartphone=  new Smartphone.SmartphoneBuilder().processor(processor2).memory(memory2);
                System.out.println(computerFactory.createProduct(smartphone));
                break;
            case "3":
                System.out.println("Quelle type de roue voulez vous ?");
                String roue=scanner.nextLine();
                Bike.BikeBuilder bike=  new Bike.BikeBuilder().typeWheels(roue);

                System.out.println(computerFactory.createProduct(bike));
                break;

        }



    }
}