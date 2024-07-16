package com.swino.trainingrest.repository.exoEmploye;


import com.swino.trainingrest.entity.exoEmploye.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
}
