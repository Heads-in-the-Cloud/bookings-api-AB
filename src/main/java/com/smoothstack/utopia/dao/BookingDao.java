package com.smoothstack.utopia.dao;

import com.smoothstack.utopia.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {}

