package com.smoothstack.utopia.service;

import com.smoothstack.utopia.dao.PassengerDao;
import com.smoothstack.utopia.entity.Passenger;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final PassengerDao dao;

    public PassengerService(final PassengerDao dao) {
        this.dao = dao;
    }

    public void save(final Passenger passenger) {
        dao.save(passenger);
    }

    public List<Passenger> selectAll() {
        return dao.findAll();
    }

    public Optional<Passenger> selectById(final Integer id) {
        return dao.findById(id);
    }

    public void delete(final Passenger passenger) {
        dao.delete(passenger);
    }
}

