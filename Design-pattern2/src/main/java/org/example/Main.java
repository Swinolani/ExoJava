package org.example;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1= new Pizza.PizzaBuilder().taille(12.2)
                .typePate("classique")
                .fromage("mozarella")
                .listeGarniture(new String[]{"pepperoni", "champignons"})
                .typeSauce("tomate")
                .build();

        System.out.println(pizza1);
    }
}