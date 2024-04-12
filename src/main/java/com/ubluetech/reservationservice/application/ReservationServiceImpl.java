package com.ubluetech.reservationservice.application;

import com.ubluetech.reservationservice.domain.Reservation;
import com.ubluetech.reservationservice.infrastructure.ReservationRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    @Override
    public boolean createReservation(Reservation reservation) {
        throw new UnsupportedOperationException("Unimplemented method 'createReservation'");
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        throw new UnsupportedOperationException("Unimplemented method 'updateReservation'");
    }

    @Override
    public boolean cancelReservation(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'cancelReservation'");
    }    
}
