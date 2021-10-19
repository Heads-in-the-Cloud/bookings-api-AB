package com.smoothstack.utopia.dao;

import com.smoothstack.utopia.entity.BookingPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingPaymentDao extends JpaRepository<BookingPayment, Integer> {}

