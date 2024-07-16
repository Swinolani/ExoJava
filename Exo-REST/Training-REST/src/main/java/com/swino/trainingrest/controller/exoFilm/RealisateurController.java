package com.swino.trainingrest.controller.exoFilm;

import com.swino.trainingrest.entity.exoFilm.Realisateur;
import com.swino.trainingrest.service.exoFilm.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/realisateurs")
public class RealisateurController {

    @Autowired
    private RealisateurService realisateurService;


    @PostMapping
    public Realisateur createRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.createRealisateur(realisateur);
    }


    @GetMapping
    public List<Realisateur> getAllRealisateurs() {
        return realisateurService.getAllRealisateurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Realisateur> getRealisateurById(@PathVariable Long id) {
        Optional<Realisateur> realisateur = realisateurService.getRealisateurById(id);
        return realisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Realisateur> updateRealisateur(@PathVariable Long id, @RequestBody Realisateur realisateurDetails) {
        try {
            Realisateur updatedRealisateur = realisateurService.updateRealisateur(id, realisateurDetails);
            return ResponseEntity.ok(updatedRealisateur);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRealisateur(@PathVariable Long id) {
        realisateurService.deleteRealisateur(id);
        return ResponseEntity.noContent().build();
    }
}