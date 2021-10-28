package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flight_bookings")
public class FlightBookings {
    @EmbeddedId
    private FlightBookingsId id;

    public FlightBookingsId getId() {
        return id;
    }
    public void setId(final FlightBookingsId id) {
        this.id = id;
    }
}
