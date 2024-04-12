package com.ubluetech.reservationservice.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubluetech.reservationservice.domain.RequestReservationCommand;
import com.ubluetech.reservationservice.infrastructure.CommandHandler;
import com.ubluetech.reservationservice.infrastructure.ReservationRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationRepository repository;
    private final ReservationMapper reservationMapper;
    private final CommandHandler<RequestReservationCommand> commandHandler;

    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return repository.
                findAll()
                .stream()
                .map(reservationMapper::entityToDto)
                .toList();
    }
    
    @GetMapping("/{id}")
    public ReservationDto getReservation(@PathVariable(value = "id") Long id) {
        return reservationMapper
                .entityToDto(
                    repository
                        .findById(id)
                        .orElse(null)
                );
    }

    @PostMapping
    public void createReservation(@RequestBody RequestReservationCommand command) {
        commandHandler.handle(command);
    }
}
