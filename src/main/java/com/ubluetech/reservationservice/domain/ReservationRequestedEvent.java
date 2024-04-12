package com.ubluetech.reservationservice.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationRequestedEvent {
    private EventType eventType;
    private Metadata metadata;
    private List<Guest> guests;
    private List<Room> rooms;
}
