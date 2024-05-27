package org.example;

public class RealBBook implements Book{
    @Override
    public void readBook(String contenu) {
        System.out.println("contenu du livre : "+contenu);
    }
}
