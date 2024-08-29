package com.swino.tphexagonalpart1.infrastructure.springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ReservationEntity {
    @Id
    private Long id;
    @ManyToOne
    private EventEntity event;
    private int numberOfTickets;

    public ReservationEntity(Long id, EventEntity event, int numberOfTickets) {
        this.id = id;
        this.event = event;
        this.numberOfTickets = numberOfTickets;
    }
    public ReservationEntity() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public EventEntity getEvent() {
        return event;
    }
    public void setEvent(EventEntity event) {
        this.event = event;
    }
    public int getNumberOfTickets() {
        return numberOfTickets;
    }
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}