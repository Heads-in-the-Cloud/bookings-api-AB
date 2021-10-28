package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "booking_user")
public class BookingUser {
    @EmbeddedId
    private BookingId id;

    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    public BookingId getId() {
        return id;
    }
    public void setId(final BookingId id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }
}
