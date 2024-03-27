package com.ubluetech.reservationservice.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "reserved_room")
@Getter
class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // The parent reference is marked as non-updatable, to prevent breaking the equals/hashCode contract
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id",
                nullable = false,
                updatable = false)
    private Reservation reservation;
    
    @Column(nullable = false)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    private BigDecimal price;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (!(obj instanceof Room))
            return false;

        return id != null && 
                id.equals(((Room) obj).getId());
    }

    
}
