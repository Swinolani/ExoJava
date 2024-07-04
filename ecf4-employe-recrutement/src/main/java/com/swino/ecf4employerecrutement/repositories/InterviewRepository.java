package com.swino.ecf4employerecrutement.repositories;

import com.swino.ecf4employerecrutement.entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
