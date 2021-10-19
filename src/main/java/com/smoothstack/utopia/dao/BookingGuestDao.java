package com.smoothstack.utopia.dao;

import com.smoothstack.utopia.entity.BookingGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingGuestDao extends JpaRepository<BookingGuest, Integer> {}

