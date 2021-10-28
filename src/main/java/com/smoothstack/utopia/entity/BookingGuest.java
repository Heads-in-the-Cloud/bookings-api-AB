package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
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

    public BookingId getId() {
        return id;
    }
    public void setId(final BookingId id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(final String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(final String phone) {
        this.phone = phone;
    }
}
