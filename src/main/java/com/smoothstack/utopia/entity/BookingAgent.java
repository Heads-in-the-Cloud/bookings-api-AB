package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "booking_agent")
public class BookingAgent {
    @EmbeddedId
    private BookingId id;

    @NotNull
    @Column(name = "agent_id")
    private Integer agentId;

    public BookingId getId() {
        return id;
    }
    public void setId(final BookingId id) {
        this.id = id;
    }
    public Integer getAgentId() {
        return agentId;
    }
    public void setAgentId(final Integer agentId) {
        this.agentId = agentId;
    }
}
