package com.smoothstack.utopia.service;

import com.smoothstack.utopia.dao.BookingGuestDao;
import com.smoothstack.utopia.entity.BookingGuest;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingGuestService {
    private final BookingGuestDao dao;

    public void save(final BookingGuest bookingGuest) {
        dao.save(bookingGuest);
    }

    public List<BookingGuest> selectAll() {
        return dao.findAll();
    }

    public Optional<BookingGuest> selectByBookingId(final Integer bookingId) {
        final List<BookingGuest> bookingGuests = dao.findById_Booking_Id(bookingId);
        return bookingGuests.isEmpty() ? Optional.empty() : Optional.of(bookingGuests.get(0));
    }

    public void delete(final BookingGuest bookingGuest) {
        dao.delete(bookingGuest);
    }
}

