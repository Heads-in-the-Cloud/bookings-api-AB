package com.smoothstack.utopia.service;

import com.smoothstack.utopia.dao.BookingUserDao;
import com.smoothstack.utopia.entity.BookingUser;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingUserService {
    private final BookingUserDao dao;

    public void save(final BookingUser bookingUser) {
        dao.save(bookingUser);
    }

    public List<BookingUser> selectAll() {
        return dao.findAll();
    }

    public Optional<BookingUser> selectByBookingId(final Integer bookingId) {
        final List<BookingUser> bookingUsers = dao.findById_Booking_Id(bookingId);
        return bookingUsers.isEmpty() ? Optional.empty() : Optional.of(bookingUsers.get(0));
    }

    public void delete(final BookingUser bookingUser) {
        dao.delete(bookingUser);
    }
}

