package com.ubluetech.reservationservice.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Metadata {
    private UUID correlationId;
    private LocalDateTime timestamp;
    private String version;
    private String source;

}
