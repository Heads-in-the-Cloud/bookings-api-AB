package com.smoothstack.utopia.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class BookingId implements Serializable {
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Override
    public int hashCode() {
        return Objects.hash(booking);
    }

    @Override
    public boolean equals(final Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final BookingId bookingId = (BookingId) obj;
        return booking.equals(bookingId.booking);
    }
}
