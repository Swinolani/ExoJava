package com.swino.tphexagonalpart1.infrastructure.springdata.repository;

import com.swino.tphexagonalpart1.infrastructure.springdata.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
