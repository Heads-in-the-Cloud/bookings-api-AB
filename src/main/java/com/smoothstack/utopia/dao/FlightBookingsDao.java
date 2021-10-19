package com.smoothstack.utopia.dao;

import com.smoothstack.utopia.entity.FlightBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingsDao extends JpaRepository<FlightBookings, Integer> {}

