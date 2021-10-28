package com.smoothstack.utopia.service;

import com.smoothstack.utopia.dao.BookingPaymentDao;
import com.smoothstack.utopia.entity.BookingPayment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingPaymentService {
    private final BookingPaymentDao dao;

    public BookingPaymentService(final BookingPaymentDao dao) {
        this.dao = dao;
    }

    public void save(final BookingPayment bookingPayment) {
        dao.save(bookingPayment);
    }

    public List<BookingPayment> selectAll() {
        return dao.findAll();
    }

    public Optional<BookingPayment> selectByBookingId(final Integer bookingId) {
        final List<BookingPayment> bookingPayments = dao.findById_Booking_Id(bookingId);
        return bookingPayments.isEmpty() ? Optional.empty() : Optional.of(bookingPayments.get(0));
    }

    public void delete(final BookingPayment bookingPayment) {
        dao.delete(bookingPayment);
    }
}

