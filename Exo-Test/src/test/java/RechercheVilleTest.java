import org.example.exception.NotFoundException;
import org.example.simpleTest.RechercheVille;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RechercheVilleTest {

    @Test
    public void testRechercheTexteMoinsDeDeuxCaracteres() {
        RechercheVille rechercheVille = new RechercheVille();
        assertThrows(NotFoundException.class, () -> {
            rechercheVille.rechercher("A");
        });
    }
    @Test
    public void testRechercheParPrefixe() throws NotFoundException {
        RechercheVille rechercheVille = new RechercheVille();
        List<String> result = rechercheVille.rechercher("Va");
        assertTrue(result.contains("Valence"));
        assertTrue(result.contains("Vancouver"));
    }
    @Test
    public void testRechercheInsensibleALaCasse() throws NotFoundException {
        RechercheVille rechercheVille = new RechercheVille();
        List<String> result = rechercheVille.rechercher("va");
        assertTrue(result.contains("Valence"));
        assertTrue(result.contains("Vancouver"));
    }
    @Test
    public void testRechercheParSousChaine() throws NotFoundException {
        RechercheVille rechercheVille = new RechercheVille();
        List<String> result = rechercheVille.rechercher("ape");
        assertTrue(result.contains("Budapest"));
    }
    @Test
    public void testRechercheAvecAsterisque() throws NotFoundException {
        RechercheVille rechercheVille = new RechercheVille();
        List<String> result = rechercheVille.rechercher("*");
        assertEquals(16, result.size());
    }



}
