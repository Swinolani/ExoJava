package com.swino.tphexagonalpart1.domain.entity;

public class Reservation {
    private Long id;
    private Event event;
    private int numberOfTickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event=event;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets=numberOfTickets;
    }

}
