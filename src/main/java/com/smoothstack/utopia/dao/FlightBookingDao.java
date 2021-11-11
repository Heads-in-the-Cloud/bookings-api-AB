package com.smoothstack.utopia.dao;

import java.util.List;

import com.smoothstack.utopia.entity.FlightBooking;
import com.smoothstack.utopia.entity.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingDao extends JpaRepository<FlightBooking, BookingId> {
    List<FlightBooking> findById_Booking_Id(final Integer bookingId);
}

