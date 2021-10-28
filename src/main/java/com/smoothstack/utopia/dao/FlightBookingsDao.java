package com.smoothstack.utopia.dao;

import java.util.List;

import com.smoothstack.utopia.entity.FlightBookings;
import com.smoothstack.utopia.entity.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingsDao extends JpaRepository<FlightBookings, BookingId> {
    List<FlightBookings> findById_Booking_Id(final Integer bookingId);
}

