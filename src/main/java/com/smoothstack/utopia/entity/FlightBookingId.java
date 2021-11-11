package com.smoothstack.utopia.entity;

import java.io.Serializable;
import java.util.Objects;

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
public class FlightBookingId implements Serializable {
    @NotNull
    @Column(name = "flight_id")
    private Integer flightId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Override
    public int hashCode() {
        return Objects.hash(flightId, booking);
    }

    @Override
    public boolean equals(final Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final FlightBookingId flightBookingId = (FlightBookingId) obj;
        return flightId.equals(flightBookingId.flightId)
            && booking.equals(flightBookingId.booking);
    }
}
