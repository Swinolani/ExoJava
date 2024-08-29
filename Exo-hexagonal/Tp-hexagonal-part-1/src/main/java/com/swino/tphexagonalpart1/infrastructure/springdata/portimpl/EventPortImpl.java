package com.swino.tphexagonalpart1.infrastructure.springdata.portimpl;

import com.swino.tphexagonalpart1.domain.entity.Event;
import com.swino.tphexagonalpart1.infrastructure.springdata.entity.EventEntity;
import com.swino.tphexagonalpart1.infrastructure.springdata.repository.EventRepository;
import com.swino.tphexagonalpart1.shared.port.EventPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EventPortImpl implements EventPort {

    private final EventRepository eventRepository;

    public EventPortImpl(EventRepository eventRepository) {
        this.eventRepository=eventRepository;
    }

    @Override
    public Optional<Event> loadEventById(Long eventId) {
        return eventRepository.findById(eventId).map(this::toDomain);
    }

    private Event toDomain(EventEntity entity) {
        Event event = new Event();
        event.setId(entity.getId());
        event.setName(entity.getName());
        event.setLocation(entity.getLocation());
        event.setAvailableTickets(entity.getAvailableTickets());
        return event;
    }
}
