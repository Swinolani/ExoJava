package org.example;

public class Client {
    public static void main(String[] args) {
        // Non securisé
        Book book=new ProxyBook(false);
        book.readBook("Un livre random");

        // Securisé
        Book book2=new ProxyBook(true);
        book2.readBook("Un autre livre random");

    }
}