package com.swino.tphexagonalpart1.infrastructure.springdata.portimpl;

import com.swino.tphexagonalpart1.domain.entity.Reservation;
import com.swino.tphexagonalpart1.infrastructure.springdata.entity.ReservationEntity;
import com.swino.tphexagonalpart1.infrastructure.springdata.repository.ReservationRepository;
import com.swino.tphexagonalpart1.shared.dto.ReservationDto;
import com.swino.tphexagonalpart1.shared.port.ReservationPort;
import org.springframework.stereotype.Component;

@Component
public class ReservationPortImpl implements ReservationPort {

    private final ReservationRepository reservationRepository;

    public ReservationPortImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationDto saveReservation(ReservationDto reservation) {
        ReservationEntity entity=new ReservationEntity();
        entity.setEvent(reservation.getEvent());
        entity.setNumberOfTickets(reservation.getNumberOfTickets());
        ReservationEntity savedEntity = reservationRepository.save(entity);
        return reservation;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return null;
    }
}
