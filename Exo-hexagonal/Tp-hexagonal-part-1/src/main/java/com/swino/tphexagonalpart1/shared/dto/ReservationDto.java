package com.swino.tphexagonalpart1.shared.dto;

import com.swino.tphexagonalpart1.domain.entity.Event;
import com.swino.tphexagonalpart1.infrastructure.springdata.entity.EventEntity;

public class ReservationDto {
    private Long eventId;
    private int numberOfTickets;
    private Event event;

    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ReservationDto(Long eventId, int numberOfTickets) {
        this.eventId = eventId;
        this.numberOfTickets = numberOfTickets;
    }

    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public int getNumberOfTickets() {
        return numberOfTickets;
    }
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
