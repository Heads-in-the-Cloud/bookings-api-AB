package com.smoothstack.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "confirmation_code")
    private String confirmationCode;

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
