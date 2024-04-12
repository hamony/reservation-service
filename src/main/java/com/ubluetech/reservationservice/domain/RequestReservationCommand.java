package com.ubluetech.reservationservice.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestReservationCommand {
    private List<Guest> guest;
}
