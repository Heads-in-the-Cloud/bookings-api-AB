package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "booking_user")
public class BookingUser {
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "user_id")
    private Integer userId;

    public Booking getBooking() {
        return booking;
    }
    public void setBooking(final Booking booking) {
        this.booking = booking;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }
}
