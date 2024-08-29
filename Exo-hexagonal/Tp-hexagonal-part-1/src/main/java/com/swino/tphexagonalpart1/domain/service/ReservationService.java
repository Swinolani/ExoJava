package com.swino.tphexagonalpart1.domain.service;

import com.swino.tphexagonalpart1.domain.entity.Event;
import com.swino.tphexagonalpart1.domain.entity.Reservation;
import com.swino.tphexagonalpart1.shared.port.EventPort;
import com.swino.tphexagonalpart1.shared.port.ReservationPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private final EventPort eventPort;
    private final ReservationPort reservationPort;

    public ReservationService(EventPort eventPort,ReservationPort reservationPort) {
        this.eventPort=eventPort;
        this.reservationPort=reservationPort;
    }

    public Reservation createReservation(Long eventId, int numberOfTickets) {
        Optional<Event> event=eventPort.loadEventById(eventId);
        if (event.isEmpty()){
            throw new RuntimeException("Event not found with id: "+eventId);
        }

        Reservation reservation=new Reservation();
        reservation.setEvent(event.get());
        reservation.setNumberOfTickets(numberOfTickets);
        return reservationPort.saveReservation(reservation);
    }
}
