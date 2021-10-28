package com.smoothstack.utopia.dao;

import java.util.List;

import com.smoothstack.utopia.entity.BookingGuest;
import com.smoothstack.utopia.entity.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingGuestDao extends JpaRepository<BookingGuest, BookingId> {
    List<BookingGuest> findById_Booking_Id(final Integer bookingId);
}

