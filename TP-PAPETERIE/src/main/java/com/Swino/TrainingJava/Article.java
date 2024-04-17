package com.Swino.TrainingJava;

public abstract class Article {
    protected String artId;

    public Article(String artId) {
        this.artId = artId;
    }

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }
}
