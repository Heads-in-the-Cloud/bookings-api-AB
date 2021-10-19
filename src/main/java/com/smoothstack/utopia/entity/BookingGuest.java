package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "booking_guest")
public class BookingGuest {
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "contact_email")
    private String email;

    @Column(name = "contact_phone")
    private String phone;

    public Booking getBooking() {
        return booking;
    }
    public void setBooking(final Booking booking) {
        this.booking = booking;
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
