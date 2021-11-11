package com.smoothstack.utopia.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class FlightBookingsId implements Serializable {
    @NotNull
    @Column(name = "flight_id")
    private Integer flightId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
