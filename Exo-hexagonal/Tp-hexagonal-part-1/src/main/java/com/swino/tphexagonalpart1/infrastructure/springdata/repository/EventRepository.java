package com.swino.tphexagonalpart1.infrastructure.springdata.repository;

import com.swino.tphexagonalpart1.infrastructure.springdata.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
