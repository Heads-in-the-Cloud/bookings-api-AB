package com.smoothstack.utopia.dao;

import java.util.List;

import com.smoothstack.utopia.entity.BookingUser;
import com.smoothstack.utopia.entity.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingUserDao extends JpaRepository<BookingUser, BookingId> {
    List<BookingUser> findById_Booking_Id(final Integer bookingId);
}

