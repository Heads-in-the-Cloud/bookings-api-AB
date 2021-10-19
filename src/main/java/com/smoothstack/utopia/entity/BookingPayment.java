package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "booking_payment")
public class BookingPayment {
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "stripe_id")
    private String stripeId;

    @Column(name = "refunded")
    private Boolean wasRefunded;

    public Booking getBooking() {
        return booking;
    }
    public void setBooking(final Booking booking) {
        this.booking = booking;
    }
    public String getStripeId() {
        return stripeId;
    }
    public void setStripeId(final String stripeId) {
        this.stripeId = stripeId;
    }
    public Boolean getWasRefunded() {
        return wasRefunded;
    }
    public void setWasRefunded(final Boolean wasRefunded) {
        this.wasRefunded = wasRefunded;
    }
}
