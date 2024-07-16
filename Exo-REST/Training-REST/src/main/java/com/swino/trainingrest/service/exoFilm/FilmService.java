package com.swino.trainingrest.service.exoFilm;

import com.swino.trainingrest.entity.exoFilm.Film;
import com.swino.trainingrest.repository.exoFilm.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;


    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }


    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(Math.toIntExact(id));
    }


    public Film updateFilm(Long id, Film filmDetails) {
        Optional<Film> optionalFilm = filmRepository.findById(Math.toIntExact(id));

        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            film.setNom(filmDetails.getNom());
            film.setDateDeSortie(filmDetails.getDateDeSortie());
            film.setDescription(filmDetails.getDescription());
            film.setDuree(filmDetails.getDuree());
            film.setGenre(filmDetails.getGenre());
            film.setRealisateur(filmDetails.getRealisateur());
            return filmRepository.save(film);
        } else {
            throw new RuntimeException("Film not found with id " + id);
        }
    }


    public void deleteFilm(Long id) {
        filmRepository.deleteById(Math.toIntExact(id));
    }
}
