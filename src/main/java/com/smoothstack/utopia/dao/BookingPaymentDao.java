package com.smoothstack.utopia.dao;

import java.util.List;

import com.smoothstack.utopia.entity.BookingPayment;
import com.smoothstack.utopia.entity.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingPaymentDao extends JpaRepository<BookingPayment, BookingId> {
    List<BookingPayment> findById_Booking_Id(final Integer bookingId);
}

