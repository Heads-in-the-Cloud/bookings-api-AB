package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "booking_agent")
public class BookingAgent {
    @EmbeddedId
    private BookingId id;

    @NotNull
    @Column(name = "agent_id")
    private Integer agentId;
}
