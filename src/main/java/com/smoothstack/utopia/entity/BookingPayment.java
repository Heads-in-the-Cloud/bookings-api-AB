package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
