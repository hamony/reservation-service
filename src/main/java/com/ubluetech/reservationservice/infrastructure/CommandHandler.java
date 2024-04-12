package com.ubluetech.reservationservice.infrastructure;

public interface CommandHandler<T> {
    void handle(T command);
}
