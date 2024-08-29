package com.swino.tphexagonalpart1.infrastructure.springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EventEntity {
    @Id
    private Long id;
    private String name;
    private String location;
    private int availableTickets;

    public EventEntity(Long id, String name, String location, int availableTickets) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.availableTickets = availableTickets;
    }
    public EventEntity() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getAvailableTickets() {
        return availableTickets;
    }
    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }
}