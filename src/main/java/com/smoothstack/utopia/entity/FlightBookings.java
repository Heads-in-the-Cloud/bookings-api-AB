package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "flight_bookings")
public class FlightBookings {
    @Column(name = "flight_id")
    private Integer flightId;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Integer getFlightId() {
        return flightId;
    }
    public void setFlightId(final Integer flightId) {
        this.flightId = flightId;
    }
    public Booking getBooking() {
        return booking;
    }
    public void setBooking(final Booking booking) {
        this.booking = booking;
    }
}
