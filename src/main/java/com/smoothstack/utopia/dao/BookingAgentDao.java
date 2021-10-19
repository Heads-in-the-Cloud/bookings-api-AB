package com.smoothstack.utopia.dao;

import com.smoothstack.utopia.entity.BookingAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingAgentDao extends JpaRepository<BookingAgent, Integer> {}

