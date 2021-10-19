package com.smoothstack.utopia.service;

import com.smoothstack.utopia.dao.BookingDao;
import com.smoothstack.utopia.entity.Booking;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingDao dao;

    public BookingService(final BookingDao dao) {
        this.dao = dao;
    }

    public void save(final Booking booking) {
        dao.save(booking);
    }

    public List<Booking> selectAll() {
        return dao.findAll();
    }

    public Optional<Booking> selectById(final Integer id) {
        return dao.findById(id);
    }

    public void delete(final Booking booking) {
        dao.delete(booking);
    }
}

