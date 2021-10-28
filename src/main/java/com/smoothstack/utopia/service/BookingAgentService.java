package com.smoothstack.utopia.service;

import com.smoothstack.utopia.dao.BookingAgentDao;
import com.smoothstack.utopia.entity.BookingAgent;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingAgentService {
    private final BookingAgentDao dao;

    public BookingAgentService(final BookingAgentDao dao) {
        this.dao = dao;
    }

    public void save(final BookingAgent bookingAgent) {
        dao.save(bookingAgent);
    }

    public List<BookingAgent> selectAll() {
        return dao.findAll();
    }

    public Optional<BookingAgent> selectByBookingId(final Integer bookingId) {
        final List<BookingAgent> bookingAgents = dao.findById_Booking_Id(bookingId);
        return bookingAgents.isEmpty() ? Optional.empty() : Optional.of(bookingAgents.get(0));
    }

    public void delete(final BookingAgent bookingAgent) {
        dao.delete(bookingAgent);
    }
}

