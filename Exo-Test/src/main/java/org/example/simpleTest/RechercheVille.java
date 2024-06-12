package org.example.simpleTest;

import org.example.exception.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RechercheVille {
    private final List<String> villes = Arrays.asList(
            "Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
            "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok",
            "Hong Kong", "Dubaï", "Rome", "Istanbul"
    );

    public List<String> rechercher(String mot) throws NotFoundException {
        if (mot.length() < 2 && !mot.equals("*")) {
            throw new NotFoundException("Le texte de recherche doit contenir au moins 2 caractères");
        }

        if (mot.equals("*")) {
            return new ArrayList<>(villes);
        }

        List<String> result = new ArrayList<>();
        for (String ville : villes) {
            if (ville.toLowerCase().contains(mot.toLowerCase())) {
                result.add(ville);
            }
        }
        return result;
    }
}
