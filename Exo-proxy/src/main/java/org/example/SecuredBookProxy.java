package org.example;

public class SecuredBookProxy implements Book{

    @Override
    public void readBook(String contenu) {
        System.out.println("contenu du livre sécurisé : "+contenu);
    }
}
