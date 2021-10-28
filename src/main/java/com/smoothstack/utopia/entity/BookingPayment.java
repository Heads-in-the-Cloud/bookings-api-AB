package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "booking_payment")
public class BookingPayment {
    @EmbeddedId
    private BookingId id;

    @NotNull
    @Size(max = 255)
    @Column(name = "stripe_id")
    private String stripeId;

    @NotNull
    @Column(name = "refunded")
    private Boolean wasRefunded;

    public BookingId getId() {
        return id;
    }
    public void setId(final BookingId id) {
        this.id = id;
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
