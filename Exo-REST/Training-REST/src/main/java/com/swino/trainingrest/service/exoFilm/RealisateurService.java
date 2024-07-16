package com.swino.trainingrest.service.exoFilm;

import com.swino.trainingrest.entity.exoFilm.Realisateur;
import com.swino.trainingrest.repository.exoFilm.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealisateurService {
    @Autowired
    private RealisateurRepository realisateurRepository;


    public Realisateur createRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);
    }

    public List<Realisateur> getAllRealisateurs() {
        return realisateurRepository.findAll();
    }

    public Optional<Realisateur> getRealisateurById(Long id) {
        return realisateurRepository.findById(id);
    }


    public Realisateur updateRealisateur(Long id, Realisateur realisateurDetails) {
        Optional<Realisateur> optionalRealisateur = realisateurRepository.findById(id);

        if (optionalRealisateur.isPresent()) {
            Realisateur realisateur = optionalRealisateur.get();
            realisateur.setNom(realisateurDetails.getNom());
            realisateur.setPrenom(realisateurDetails.getPrenom());
            realisateur.setDateDeNaissance(realisateurDetails.getDateDeNaissance());
            realisateur.setNationalite(realisateurDetails.getNationalite());
            return realisateurRepository.save(realisateur);
        } else {
            throw new RuntimeException("Realisateur not found with id " + id);
        }
    }


    public void deleteRealisateur(Long id) {
        realisateurRepository.deleteById(id);
    }
}
