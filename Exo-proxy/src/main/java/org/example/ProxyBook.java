package org.example;

public class ProxyBook implements  Book{
    private boolean abbonepremium=false;
    private Book book;

    public ProxyBook(boolean abbonepremium) {
        this.abbonepremium = abbonepremium;

    }

    @Override
    public void readBook(String contenu) {
        if(abbonepremium){
            book=new SecuredBookProxy();
        }else{
            book=new RealBBook();
        }
        book.readBook(contenu);
    }

    public void setAbbonepremium(boolean abbonepremium) {
        this.abbonepremium = abbonepremium;
    }
}
