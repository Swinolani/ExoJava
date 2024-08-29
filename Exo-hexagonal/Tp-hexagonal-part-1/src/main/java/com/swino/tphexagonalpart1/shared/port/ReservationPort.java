package com.swino.tphexagonalpart1.shared.port;

import com.swino.tphexagonalpart1.domain.entity.Reservation;

public interface ReservationPort {
    Reservation saveReservation(Reservation reservation);
}
