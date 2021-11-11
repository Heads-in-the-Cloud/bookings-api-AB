package com.smoothstack.utopia.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "passenger")
public class Passenger {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @NotNull
    @Size(max = 255)
    @Column(name = "given_name")
    private String givenName;

    @NotNull
    @Size(max = 255)
    @Column(name = "family_name")
    private String familyName;

    @NotNull
    @Column(name = "dob")
    private Timestamp dateOfBirth;

    @NotNull
    @Size(max = 45)
    private String gender;

    @NotNull
    @Size(max = 45)
    private String address;
}
