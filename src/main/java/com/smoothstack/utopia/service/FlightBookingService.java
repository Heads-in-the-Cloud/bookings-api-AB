package com.smoothstack.utopia.service;

import com.smoothstack.utopia.dao.FlightBookingDao;
import com.smoothstack.utopia.entity.FlightBooking;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FlightBookingService {
    private final FlightBookingDao dao;

    public void save(final FlightBooking flightBooking) {
        dao.save(flightBooking);
    }

    public List<FlightBooking> selectAll() {
        return dao.findAll();
    }

    public Optional<FlightBooking> selectByBookingId(final Integer bookingId) {
        final List<FlightBooking> flightBookings = dao.findById_Booking_Id(bookingId);
        return flightBookings.isEmpty() ? Optional.empty() : Optional.of(flightBookings.get(0));
    }

    public void delete(final FlightBooking flightBooking) {
        dao.delete(flightBooking);
    }
}

