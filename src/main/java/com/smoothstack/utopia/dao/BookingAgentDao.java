package com.smoothstack.utopia.dao;

import java.util.List;

import com.smoothstack.utopia.entity.BookingAgent;
import com.smoothstack.utopia.entity.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingAgentDao extends JpaRepository<BookingAgent, BookingId> {
    List<BookingAgent> findById_Booking_Id(final Integer bookingId);
}

