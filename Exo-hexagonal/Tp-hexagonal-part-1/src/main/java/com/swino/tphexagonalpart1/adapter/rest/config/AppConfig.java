package com.swino.tphexagonalpart1.adapter.rest.config;

import com.swino.tphexagonalpart1.domain.service.ReservationService;
import com.swino.tphexagonalpart1.infrastructure.springdata.portimpl.EventPortImpl;
import com.swino.tphexagonalpart1.infrastructure.springdata.portimpl.ReservationPortImpl;
import com.swino.tphexagonalpart1.infrastructure.springdata.repository.EventRepository;
import com.swino.tphexagonalpart1.infrastructure.springdata.repository.ReservationRepository;
import com.swino.tphexagonalpart1.shared.port.EventPort;
import com.swino.tphexagonalpart1.shared.port.ReservationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final EventRepository eventRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public AppConfig(EventRepository eventRepository,ReservationRepository reservationRepository) {
        this.eventRepository=eventRepository;
        this.reservationRepository=reservationRepository;
    }

    @Bean
    public ReservationService reservationService() {
        return new ReservationService(eventPort(),reservationPort());
    }

    @Bean
    public EventPort eventPort() {
        return new EventPortImpl(eventRepository);
    }

    @Bean
    public ReservationPort reservationPort() {
        return new ReservationPortImpl(reservationRepository);
    }
}
