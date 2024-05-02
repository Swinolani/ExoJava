package com.Swino.TrainingJava;

public class InvalidAgeException extends Exception{
    public InvalidAgeException() {
        super("L'age ne doit pas être négatif");
    }
}
