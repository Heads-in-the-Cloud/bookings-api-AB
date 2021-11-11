package com.smoothstack.utopia.service;

import com.smoothstack.utopia.dao.FlightBookingsDao;
import com.smoothstack.utopia.entity.FlightBookings;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FlightBookingsService {
    private final FlightBookingsDao dao;

    public void save(final FlightBookings flightBookings) {
        dao.save(flightBookings);
    }

    public List<FlightBookings> selectAll() {
        return dao.findAll();
    }

    public Optional<FlightBookings> selectByBookingId(final Integer bookingId) {
        final List<FlightBookings> flightBookingss = dao.findById_Booking_Id(bookingId);
        return flightBookingss.isEmpty() ? Optional.empty() : Optional.of(flightBookingss.get(0));
    }

    public void delete(final FlightBookings flightBookings) {
        dao.delete(flightBookings);
    }
}

