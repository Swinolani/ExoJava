package com.swino.tphexagonalpart1.adapter.rest.controller;

import com.swino.tphexagonalpart1.domain.entity.Reservation;
import com.swino.tphexagonalpart1.domain.service.ReservationService;
import com.swino.tphexagonalpart1.shared.dto.ReservationDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService=reservationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.createReservation(reservationDto.getEventId(),reservationDto.getNumberOfTickets());
    }
}
