package com.swino.ecf4employerecrutement.repositories;

import com.swino.ecf4employerecrutement.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByOfferId(Long offerId);
}
