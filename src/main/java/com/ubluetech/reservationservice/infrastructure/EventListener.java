package com.ubluetech.reservationservice.infrastructure;

public interface EventListener<T> {
    void onEvent(T event);
}
