package com.swino.tphexagonalpart1.shared.dto;

public class EventDto {
    private Long id;
    private String name;
    private String location;
    private int availableTickets;

    public EventDto(Long id, String name, int availableTickets, String location) {
        this.id = id;
        this.name = name;
        this.availableTickets = availableTickets;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
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
    public int getAvailableTickets() {
        return availableTickets;
    }
    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }
}
