package com.swino.trainingrest.repository.exoEmploye;

import com.swino.trainingrest.entity.exoEmploye.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
}
