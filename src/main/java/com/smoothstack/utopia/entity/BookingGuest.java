package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "booking_guest")
public class BookingGuest {
    @EmbeddedId
    private BookingId id;

    @NotNull
    @Size(max = 255)
    @Column(name = "contact_email")
    private String email;

    @NotNull
    @Size(max = 45)
    @Column(name = "contact_phone")
    private String phone;
}
