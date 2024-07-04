package com.swino.ecf4employerecrutement.repositories;

import com.swino.ecf4employerecrutement.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
