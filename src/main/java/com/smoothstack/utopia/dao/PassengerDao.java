package com.smoothstack.utopia.dao;

import com.smoothstack.utopia.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDao extends JpaRepository<Passenger, Integer> {}

