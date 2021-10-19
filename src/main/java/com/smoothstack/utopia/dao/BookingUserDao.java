package com.smoothstack.utopia.dao;

import com.smoothstack.utopia.entity.BookingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingUserDao extends JpaRepository<BookingUser, Integer> {}

