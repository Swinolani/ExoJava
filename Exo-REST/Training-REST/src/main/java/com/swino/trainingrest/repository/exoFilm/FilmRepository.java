package com.swino.trainingrest.repository.exoFilm;

import com.swino.trainingrest.entity.exoFilm.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
