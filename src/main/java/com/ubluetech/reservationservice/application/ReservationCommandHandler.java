package com.ubluetech.reservationservice.application;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ubluetech.reservationservice.domain.RequestReservationCommand;
import com.ubluetech.reservationservice.domain.ReservationRequestedEvent;
import com.ubluetech.reservationservice.infrastructure.CommandHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
class ReservationCommandHandler implements CommandHandler<RequestReservationCommand> {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void handle(RequestReservationCommand command) {
        ReservationRequestedEvent event = new ReservationRequestedEvent();
        kafkaTemplate.send("reservation", event);
    }
    
}
