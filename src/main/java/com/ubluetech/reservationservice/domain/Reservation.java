package com.ubluetech.reservationservice.domain;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Guest guest;

    @OneToMany(mappedBy = "reservation",
               cascade = CascadeType.ALL,
               orphanRemoval = true)   
    private Set<Room> rooms;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
