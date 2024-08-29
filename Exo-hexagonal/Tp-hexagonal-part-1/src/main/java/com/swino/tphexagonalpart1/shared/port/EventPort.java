package com.swino.tphexagonalpart1.shared.port;

import com.swino.tphexagonalpart1.domain.entity.Event;

import java.util.Optional;

public interface EventPort {
    Optional<Event> loadEventById(Long eventId);
}
