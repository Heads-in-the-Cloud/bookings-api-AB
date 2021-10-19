package com.smoothstack.utopia.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "booking_agent")
public class BookingAgent {
    @Column(name = "booking_id")
    private Booking booking;

    @Column(name = "agent_id")
    private Integer agentId;

    public Integer getId() {
        return id;
    }
    public void setId(final Integer id) {
        this.id = id;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(final Boolean isActive) {
        this.isActive = isActive;
    }
    public String getConfirmationCode() {
        return confirmationCode;
    }
    public void setConfirmationCode(final String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
