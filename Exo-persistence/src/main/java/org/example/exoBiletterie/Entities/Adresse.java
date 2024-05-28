package org.example.exoBiletterie.Entities;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Inheritance(strategy = InheritanceType.JOINED)
public class Adresse {

    protected String rue;
    protected String ville;
}
